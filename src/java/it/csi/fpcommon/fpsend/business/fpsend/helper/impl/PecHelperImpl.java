package it.csi.fpcommon.fpsend.business.fpsend.helper.impl;

import it.csi.fpcommon.fpsend.business.fpsend.helper.PecHelper;
import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.dto.fpsend.RequestRecuperaPec;
import it.csi.fpcommon.fpsend.dto.fpsend.ResponseRecuperaPec;
import it.csi.fpcommon.fpsend.exception.fpsend.RecuperaPecException;
import it.legalmail.client.imap.Caches;
import it.legalmail.client.imap.Folder;
import it.legalmail.client.imap.FolderName;
import it.legalmail.client.imap.IMAPMessageProperties;
import it.legalmail.client.imap.Store;
import it.legalmail.client.imap.Stores;
import it.legalmail.client.message.Message;
import it.legalmail.client.message.MessageProperties;
import it.legalmail.client.pec.PECMessages;
import it.legalmail.client.pec.PECType;
import it.legalmail.client.server.Connection;
import it.legalmail.client.server.Server;
import it.legalmail.client.server.Servers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.search.HeaderTerm;
import javax.mail.search.SearchTerm;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



public class PecHelperImpl implements PecHelper {


	public static final String LOGGER_PREFIX = "stasend.helper";

	private static Logger log = Logger.getLogger(LOGGER_PREFIX);

	private String imap;

	private String userId;

	private String password;

	public void setImap(String imap) {
		this.imap = imap;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private static final String HEADER_MESSAGE_ID = "X-Riferimento-Message-ID";



	/**
	 * Verifico nella inbox se è presente l'esito di invio dell'accertamento tramite PEC.
	 * La ricerca dell'esito viene fatta nella folder INBOX
	 *
	 * @param request
	 * @return
	 * @throws RecuperaPecException
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public ResponseRecuperaPec recuperaPec(RequestRecuperaPec request) throws RecuperaPecException {
		final String method = "recuperaPec";

		if(request==null)
			throw new RecuperaPecException("Request is null");
		if(request.getMessageId() == null)
			throw new RecuperaPecException("Id message is null");


		ResponseRecuperaPec response = new ResponseRecuperaPec();
		String messageId = request.getMessageId();

		Server server = Servers.newServer(imap, Connection.SSL);
		Store store = Stores.newStore(server, userId, password);

		try {
			Tracer.info(log, getClass().getName(), method, "Connessione al client PEC");
			store.connect();

			Tracer.info(log, getClass().getName(), method, "Recupero inbox");
			Folder inbox = getInboxFolder(store);
			if (inbox == null) {
				throw new RecuperaPecException("Impossibile determinare inbox folder!");
			}

			// Verifico esito
			Tracer.info(log, getClass().getName(), method, "Verifico esito");

            String esito = isMessageReceived(inbox, messageId) ?ResponseRecuperaPec.MESSAGGIO_RICEVUTO : ResponseRecuperaPec.MESSAGGIO_NON_RICEVUTO;

			response.setEsito(esito);


			// Recupero Messaggio
			Tracer.info(log, getClass().getName(), method, "Ricerco messaggi con MessageId: " + request.getMessageId());

			SearchTerm msgIdTerm = new HeaderTerm(HEADER_MESSAGE_ID, messageId);
			Collection<IMAPMessageProperties> messageList = inbox.imapSearch(msgIdTerm);

			if (messageList.size() != 2) {
				String err = "Impossibile recuperare messaggio esito. Sono attesi 2 messaggi. Trovati: " + messageList.size();
				Tracer.error(log, getClass().getName(), method, err);
				throw new Exception(err);
			}

			Tracer.info(log, getClass().getName(), method, "Ricerco esito tra i messaggi trovati");
			for (IMAPMessageProperties messageProperties : messageList) {

				// skippo le ricevute di accettazione
				if (isRicevutaDiAccetazione(messageProperties)) {
					Tracer.info(log, getClass().getName(), method, "Ricevuta di accettazione trovata. Skippo messaggio");
					continue;
				}
				// non essendo il messaggio una ricevuta di accettazione, assumo sia l'esito

				Message message = inbox.getMessage(messageProperties.getUID());
				if (message == null) {
					String err = "Impossibile recuperare messaggio con UID: " + messageProperties.getUID();
					Tracer.error(log, getClass().getName(), method, err);
					throw new Exception(err);
				}

				Tracer.info(log, getClass().getName(), method, "Messaggio recuperato");
				Tracer.info(log, getClass().getName(), method, "UID:" + messageProperties.getUID() + " Oggetto: " + messageProperties.getSubject());

				// recupero file
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				message.writeTo(baos);
				baos.close();

				Date dataConsegna = message.getHeader().getSendDate();
				String pecType = PECMessages.getPECType(messageProperties).toString();

				response.setFile(baos.toByteArray());
				response.setPecType(pecType);
				response.setDataConsegna(dataConsegna);

				return response;
			}

		} catch(Exception e){
			Tracer.error(log,  getClass().getName(), method, "Exception " + e);
			throw new RecuperaPecException(e.getMessage(), e);
		}

		throw new RecuperaPecException("Non è stato possibile recuperare l'esito");
	}

	/**
	 * Verifica se un messaggio è stato ricevuto. La verifica si basa sulla  ricerca di una ricevuta di consegna con
	 * con header 'X-Riferimento-Message-ID' che coincide con il MESSAGE-ID del messaggio inviato.
	 * Per verificare se è in errore basta controllare per type:
	 * BUSTA_DI_ANOMALIA,
	 * AVVISO_DI_NON_ACCETTAZIONE,
	 * AVVISO_DI_NON_ACCETTAZIONE_PER_VIRUS,
	 * AVVISO_DI_MANCATA_CONSEGNA,
	 * AVVISO_DI_MANCATA_CONSEGNA_PER_VIRUS,
	 * AVVISO_DI_RILEVAZIONE_VIRUS,
	 * PREAVVISO_DI_MANCATA_CONSEGNA_PER_SCADENZA;
	 *
	 * @param folder
	 * @param messageID
	 * @return
	 * @throws MessagingException
	 * @throws IOException
	 * @author InfoCert
	 */
	public boolean isMessageReceived(Folder folder, String messageID) throws MessagingException, IOException {
		//ricerca di messaggi basandosi sull'header
		SearchTerm msgIdTerm = new HeaderTerm(HEADER_MESSAGE_ID, messageID);
		Collection<IMAPMessageProperties> messageList = folder.imapSearch(msgIdTerm);

		List<Long> messageUIDList = new ArrayList<>();
		for (IMAPMessageProperties message : messageList) {
			messageUIDList.add(message.getUID());
		}
		if (messageUIDList.isEmpty()) {
			return false;
		}

		Map<Long, IMAPMessageProperties> messagePropertiesMap = folder.getMessagesProperties(messageUIDList);
		if (messagePropertiesMap == null || messagePropertiesMap.isEmpty()) {
			return false;
		}

		for (IMAPMessageProperties messageProperties : messagePropertiesMap.values()) {
			if (PECType.RICEVUTA_DI_AVVENUTA_CONSEGNA.equals(PECMessages.getPECType(messageProperties))) {
				return true;
			}
		}

		return false;
	}

	private boolean isRicevutaDiAccetazione(MessageProperties messageProperties) {
		return PECType.RICEVUTA_DI_ACCETTAZIONE.equals(PECMessages.getPECType(messageProperties));
	}

	private static boolean isInboxFolder(FolderName folder) {
		return folder.depth() == 1 && folder.getParentName() == null;
	}

	private static Folder getInboxFolder(Store store) throws MessagingException {

		FolderName inboxFolderName = null;
		List<FolderName> folders = store.getFolderList();

		for (FolderName folderName : folders) {
			if (isInboxFolder(folderName)) {
				inboxFolderName = folderName;
			}
		}

		if (inboxFolderName == null) {
			return null;
		}

		return store.getFolder(inboxFolderName, Caches.newMemoryCache());
	}

}