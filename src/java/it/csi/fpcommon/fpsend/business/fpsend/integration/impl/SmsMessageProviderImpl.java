package it.csi.fpcommon.fpsend.business.fpsend.integration.impl;

import it.csi.fpcommon.fpsend.business.adapter.IDtoAdapter;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTMessaggioDto;
import it.csi.fpcommon.fpsend.business.fpsend.helper.impl.MessageProcessingHelperImpl;
import it.csi.fpcommon.fpsend.business.fpsend.integration.MessageProvider;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.MessageProviderRequest;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.MessageProviderResponse;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.ProviderResponse;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.richiesta.RICHIESTASMS;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.richiesta.SMS;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.risposta.nodetail.MESSAGGIO;
import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.business.util.XmlSerializer;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;
import it.csi.fpcommon.fpsend.exception.fpsend.DtoConversionException;
import it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class SmsMessageProviderImpl  implements MessageProvider {

	public static final String LOGGER_PREFIX = "stasend.integration";

	private static Logger log = Logger.getLogger(LOGGER_PREFIX);


	private IDtoAdapter<SMS, Message> smsMessageAdapterImpl;

	private String urlGatewayOnline;
	private String usernameOnline;
	private String passwordOnline;
	private String codiceProgettoOnline;


	private String urlGatewayBatch;
	private String usernameBatch;
	private String passwordBatch;
	private String codiceProgettoBatch;


	private String replayDetail = "none";
	private int numeroMassimoSmsPerRichiesta;

	public static Logger getLog() {
		return log;
	}


	public String getUrlGatewayOnline() {
		return urlGatewayOnline;
	}

	public void setUrlGatewayOnline(String urlGatewayOnline) {
		this.urlGatewayOnline = urlGatewayOnline;
	}

	public String getUsernameOnline() {
		return usernameOnline;
	}

	public void setUsernameOnline(String usernameOnline) {
		this.usernameOnline = usernameOnline;
	}

	public String getPasswordOnline() {
		return passwordOnline;
	}

	public void setPasswordOnline(String passwordOnline) {
		this.passwordOnline = passwordOnline;
	}

	public String getCodiceProgettoOnline() {
		return codiceProgettoOnline;
	}

	public void setCodiceProgettoOnline(String codiceProgettoOnline) {
		this.codiceProgettoOnline = codiceProgettoOnline;
	}

	public String getUrlGatewayBatch() {
		return urlGatewayBatch;
	}

	public void setUrlGatewayBatch(String urlGatewayBatch) {
		this.urlGatewayBatch = urlGatewayBatch;
	}

	public String getUsernameBatch() {
		return usernameBatch;
	}

	public void setUsernameBatch(String usernameBatch) {
		this.usernameBatch = usernameBatch;
	}

	public String getPasswordBatch() {
		return passwordBatch;
	}

	public void setPasswordBatch(String passwordBatch) {
		this.passwordBatch = passwordBatch;
	}

	public String getCodiceProgettoBatch() {
		return codiceProgettoBatch;
	}

	public void setCodiceProgettoBatch(String codiceProgettoBatch) {
		this.codiceProgettoBatch = codiceProgettoBatch;
	}

	public String getReplayDetail() {
		return replayDetail;
	}

	public void setReplayDetail(String replayDetail) {
		this.replayDetail = replayDetail;
	}

	public static String getLoggerPrefix() {
		return LOGGER_PREFIX;
	}

	public int getNumeroMassimoSmsPerRichiesta() {
		return numeroMassimoSmsPerRichiesta;
	}

	public void setNumeroMassimoSmsPerRichiesta(int numeroMassimoSmsPerRichiesta) {
		this.numeroMassimoSmsPerRichiesta = numeroMassimoSmsPerRichiesta;
	}





	public IDtoAdapter<SMS, Message> getSmsMessageAdapterImpl() {
		return smsMessageAdapterImpl;
	}

	public void setSmsMessageAdapterImpl(
			IDtoAdapter<SMS, Message> smsMessageAdapterImpl) {
		this.smsMessageAdapterImpl = smsMessageAdapterImpl;
	}

	/**
	 * 
	 * @return
	 */
	public RICHIESTASMS createRichiestaSMS(String username, String password, String codiceProgetto){
		RICHIESTASMS richiestaSms = new RICHIESTASMS();

		richiestaSms.setUSERNAME(username);
		richiestaSms.setPASSWORD(password);
		richiestaSms.setCODICEPROGETTO(codiceProgetto);
		richiestaSms.setREPLYDETAIL(replayDetail);

		return richiestaSms;
	}





	public MESSAGGIO inviaSms (RICHIESTASMS richiestaSms, String urlGateway)  throws  SendMessageException {
		String method = "inviaSms";

		MESSAGGIO messaggioRisposta = null;

		try {
			if(log.isDebugEnabled()){
				Tracer.debug(log, getClass().getName(), method, "********** RICHIESTA SMS *************");
				Tracer.debug(log, getClass().getName(), method, XmlSerializer.objectToXml(richiestaSms));
			}

			JAXBContext jaxbContext;

			jaxbContext = JAXBContext.newInstance(RICHIESTASMS.class.getPackage().getName());


			Marshaller marshaller = jaxbContext.createMarshaller();
			StringWriter sw = new StringWriter();
			marshaller.marshal(richiestaSms, sw);


			Tracer.debug(log, getClass().getName(), method, "XML \n " + sw);

			String xmlSms = sw.toString();

			String intestazioneXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";

			if(StringUtils.contains(sw.toString(), intestazioneXml)){
				Tracer.debug(log, getClass().getName(), method, "rimuovo l'intestazione");
				xmlSms = StringUtils.remove(sw.toString(), intestazioneXml);
			}


			Tracer.debug(log, getClass().getName(), method, "xmlSms \n " + xmlSms);

			Tracer.debug(log, getClass().getName(), method, "chiamata al servizio");


			HttpClient client = new HttpClient();


			PostMethod post = new PostMethod(urlGateway);

			NameValuePair[] data = {new NameValuePair("xmlSms", xmlSms)};

			post.setRequestBody(data);

			client.executeMethod(post);

			String responseBody = post.getResponseBodyAsString();

			Tracer.debug(log, getClass().getName(), method, "Response Body= " + responseBody);


			JAXBContext jaxbContextResponse = JAXBContext.newInstance(MESSAGGIO.class.getPackage().getName());

			Unmarshaller unmarshaller = jaxbContextResponse.createUnmarshaller();

			messaggioRisposta = (MESSAGGIO)unmarshaller.unmarshal(new ByteArrayInputStream(responseBody.getBytes()));

		} catch (JAXBException e) {
			Tracer.error(log, getClass().getName(), method, "JAXBException " + e);
			throw new SendMessageException(e.getMessage());

		} catch (HttpException e) {
			Tracer.error(log, getClass().getName(), method, "Errore in fase di invio SMS");
			Tracer.error(log, getClass().getName(), method, "HttpException " + e);
			throw new SendMessageException(e.getMessage());
		} catch (IOException e) {
			Tracer.error(log, getClass().getName(), method, "Errore in fase di invio SMS");
			Tracer.error(log, getClass().getName(), method, "IOException " + e);
			throw new SendMessageException(e.getMessage());
		}
		catch (Exception e) {
			Tracer.error(log, getClass().getName(), method, "Errore in fase di invio SMS");
			Tracer.error(log, getClass().getName(), method, "Exception " + e);
			throw new SendMessageException(e.getMessage());
		}
		return messaggioRisposta;
	}


	public SMS convertMessage(Message message) throws DtoConversionException{
		return smsMessageAdapterImpl.convertFrom(message);
	}

	public List<SMS> convertMessage(List<Message> messages) throws DtoConversionException{

		String method = "convertMessage"; 
		List<SMS> smsToSend =  smsMessageAdapterImpl.convertFrom(messages);
		Tracer.debug(log, getClass().getName(), method, "sending " + smsToSend.size() + " SMS (s)");
		return smsToSend;

	}


	public ProviderResponse execute(Message message) throws SendMessageException {


		String method = "execute";
		
		
		ProviderResponse response = null;
		
		if(log.isDebugEnabled()){
			Tracer.debug(log, getClass().getName(), method, "urlGatewayOnline     = " + urlGatewayOnline);
			Tracer.debug(log, getClass().getName(), method, "usernameOnline       = " + usernameOnline);
			Tracer.debug(log, getClass().getName(), method, "passwordOnline       = " + passwordOnline);
			Tracer.debug(log, getClass().getName(), method, "codiceProgettoOnline = " + codiceProgettoOnline);
		}

		try{

			SMS sms = convertMessage(message);

			if(log.isDebugEnabled()){
				Tracer.debug(log, getClass().getName(), method, "********** SENDING SMS *************");
				Tracer.debug(log, getClass().getName(), method, "CODIFICA     = " + sms.getCODIFICA());
				Tracer.debug(log, getClass().getName(), method, "DATAINVIO    = " + sms.getDATAINVIO());
				Tracer.debug(log, getClass().getName(), method, "NOTE         = " + sms.getNOTE());
				Tracer.debug(log, getClass().getName(), method, "PRIORITA     = " + sms.getPRIORITA());
				Tracer.debug(log, getClass().getName(), method, "TELEFONO     = " + sms.getTELEFONO());
				Tracer.debug(log, getClass().getName(), method, "TESTO        = " + sms.getTESTO());
				Tracer.debug(log, getClass().getName(), method, "TTL          = " + sms.getTTL());
			}


			RICHIESTASMS richiestaSms = createRichiestaSMS(getUsernameOnline(), getPasswordOnline(), getCodiceProgettoOnline());
			richiestaSms.getSMS().add(sms);


			MESSAGGIO messaggioRisposta = inviaSms(richiestaSms, getUrlGatewayOnline());


			if(StringUtils.equalsIgnoreCase(messaggioRisposta.getTITOLO(), "ERRORE") ){
				Tracer.error(log, getClass().getName(), method, "Si � verificato un errore nell'invio del messaggio");
				throw new SendMessageException(messaggioRisposta.getTITOLO());
			}


		}
		catch(DtoConversionException e){
			Tracer.error(log, getClass().getName(), method, "DtoConversionException " + e);
			throw new SendMessageException(e.getMessage());
		} 
		catch (SendMessageException e) {
			Tracer.error(log, getClass().getName(), method, "SendMessageException " + e);
			throw new SendMessageException(e.getMessage());
		}
		return response;

	}

	/*
	 * (non-Javadoc)
	 * @see it.csi.stacore.stasend.business.stasend.integration.MessageProvider#execute(it.csi.stacore.stasend.business.stasend.integration.dto.MessageProviderRequest)
	 */
	public MessageProviderResponse execute( MessageProviderRequest request)  {
		String method = "execute";

		MessageProviderResponse response = new MessageProviderResponse(request.getChannel(), request.getMessages(), request.getSendTMessagesMap());

		if(log.isDebugEnabled()){
			Tracer.debug(log, getClass().getName(), method, "urlGatewayBatch     = " + urlGatewayBatch);
			Tracer.debug(log, getClass().getName(), method, "usernameBatch       = " + usernameBatch);
			Tracer.debug(log, getClass().getName(), method, "passwordBatch       = " + passwordBatch);
			Tracer.debug(log, getClass().getName(), method, "codiceProgettoBatch = " + codiceProgettoBatch);
			Tracer.debug(log, getClass().getName(), method, "ci sono " + request.getMessages().size() + " da inviare");
			Tracer.debug(log, getClass().getName(), method, "numeroMassimoSmsPerRichiesta = " + getNumeroMassimoSmsPerRichiesta());
		}

		RICHIESTASMS richiestaSms = null;

		MESSAGGIO messaggioRisposta = null;
		
		try{

			//List<SMS> smsTotaliDaInviare =  convertMessage(request.getMessages());
			List<Message> smsTotaliDaInviare =  request.getMessages();


			List<List<Message>> listaDiListe = new ArrayList<List<Message>>();
			List<Message> listaParcellizzata = null;

			int count = 0;
			

			for(int i=0; i< request.getMessages().size(); i++){
				if(i==0 || count == getNumeroMassimoSmsPerRichiesta()){
					Tracer.debug(log, getClass().getName(), method, "nuova lista ");
					listaParcellizzata = new ArrayList<Message>();
					listaDiListe.add(listaParcellizzata);
					count = 0;
				}
				Tracer.debug(log, getClass().getName(), method, "adding message " + smsTotaliDaInviare.get(i).getPk());
				listaParcellizzata.add(smsTotaliDaInviare.get(i));

				count++;
			}
			
			Tracer.debug(log, getClass().getName(), method, "parcellizate " + listaDiListe.size() + " richieste da inviare al gateway");
			
			for(List<Message> list : listaDiListe){

				Tracer.info(log, getClass().getName(), method, "sending " + list.size() + " SMS(s) ");

				richiestaSms = createRichiestaSMS(getUsernameBatch(), getPasswordBatch(), getCodiceProgettoBatch());
				richiestaSms.getSMS().addAll(convertMessage(list));

				Tracer.debug(log, getClass().getName(), method, "invio SMS");

				try{

					messaggioRisposta = inviaSms(richiestaSms, getUrlGatewayBatch());
					
					Tracer.info(log, getClass().getName(), method, "Gateway response= " + messaggioRisposta.getTITOLO() + "; " + messaggioRisposta.getDESCRIZIONE());
					
					
					

					if(StringUtils.equalsIgnoreCase(messaggioRisposta.getTITOLO(), "ERRORE") ){
						Tracer.error(log, getClass().getName(), method, "Si e' verificato un errore applicativo nell'invio degli SMS");
						throw new SendMessageException(messaggioRisposta.getTITOLO());
					}

					Tracer.info(log, getClass().getName(), method, "SMS(s) sent correctly");
					
					for(Message message : list){
						for(SendTMessaggioDto dto : response.getAllSendTMessaggioDto()){
							if(dto.getIdJmsMessaggio() == message.getPk()){
								Tracer.debug(log, getClass().getName(), method, "message " + dto.getIdJmsMessaggio() + " elaborato con successo!");
								response.addSendTMessaggioToStatusMap(MessageProcessingHelperImpl.STATO_MESSAGGIO_ELABORATO, dto);
							}
						}
					}

				}
				catch(SendMessageException e){
					Tracer.error(log, getClass().getName(), method, "Si e' verificato un errore in fase di invio sms: " + e.getMessage());
					response.setContainError(true);
					for(Message message : list){
						for(SendTMessaggioDto dto : response.getAllSendTMessaggioDto()){
							if(dto.getIdJmsMessaggio() == message.getPk()){
								Tracer.warn(log, getClass().getName(), method, "message " + dto.getIdJmsMessaggio() + " scartato");
								response.addSendTMessaggioToStatusMap(MessageProcessingHelperImpl.STATO_MESSAGGIO_SCARTATO, dto);
							}
						}
					}
				}

				

			}

			/*
			for(SendTMessaggioDto dto : response.getAllSendTMessaggioDto()){
				response.addSendTMessaggioToStatusMap(MessageProcessingHelperImpl.STATO_MESSAGGIO_ELABORATO, dto);
			}
			 */

		}
		catch(DtoConversionException e){
			Tracer.error(log, getClass().getName(), method, "DtoConversionException " + e);
			for(SendTMessaggioDto dto : response.getAllSendTMessaggioDto()){
				response.addSendTMessaggioToStatusMap(MessageProcessingHelperImpl.STATO_MESSAGGIO_SCARTATO, dto);
			}
		}
		/*
		catch (SendMessageException e) {
			Tracer.error(log, getClass().getName(), method, "SendMessageException " + e);
			response.setContainError(true);
			for(SendTMessaggioDto dto : response.getAllSendTMessaggioDto()){
				response.addSendTMessaggioToStatusMap(MessageProcessingHelperImpl.STATO_MESSAGGIO_SCARTATO, dto);
			}
		}
		 */
		catch (Exception e) {
			Tracer.error(log, getClass().getName(), method, "Exception " + e);
			response.setContainError(true);
			for(SendTMessaggioDto dto : response.getAllSendTMessaggioDto()){
				response.addSendTMessaggioToStatusMap(MessageProcessingHelperImpl.STATO_MESSAGGIO_SCARTATO, dto);
			}
		}

		return response;


	}

}
