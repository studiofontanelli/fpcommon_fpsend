package it.csi.fpcommon.fpsend.business.fpsend.helper.impl;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.SendDTipoCanaleDao;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.SendRFruitoreCanaleDao;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.SendTFruitoreDao;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.SendTMessaggioDao;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.SendTRichiestaDao;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendDTipoCanaleDto;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTFruitoreDto;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTMessaggioDto;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTRichiestaDto;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.SendDTipoCanaleDaoException;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.SendTFruitoreDaoException;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.SendTRichiestaDaoException;
import it.csi.fpcommon.fpsend.business.fpsend.helper.MessageProcessingHelper;
import it.csi.fpcommon.fpsend.business.fpsend.helper.MessageSenderHelper;
import it.csi.fpcommon.fpsend.business.fpsend.helper.ResponseInsertMessageDto;
import it.csi.fpcommon.fpsend.business.fpsend.helper.ResponseInsertMessagesDto;
import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.business.util.XmlSerializer;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;
import it.csi.fpcommon.fpsend.dto.fpsend.RequestMessage;
import it.csi.fpcommon.fpsend.dto.fpsend.RequestMessages;
import it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.support.incrementer.PostgreSQLSequenceMaxValueIncrementer;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class MessageSenderHelperImpl implements MessageSenderHelper {


	public static final String LOGGER_PREFIX = "stasend.helper";

	private static Logger log = Logger.getLogger(LOGGER_PREFIX);

	// SEQUENCE LIST
	private PostgreSQLSequenceMaxValueIncrementer sendTRichiestaDaoIncrementer;

	// DAO LIST
	private SendTFruitoreDao sendTFruitoreDao;
	private SendRFruitoreCanaleDao sendRFruitoreCanaleDao;
	private SendDTipoCanaleDao sendDTipoCanaleDao;
	private SendTRichiestaDao sendTRichiestaDao;
	private SendTMessaggioDao sendTMessaggioDao;
	

	// HELPER
	private MessageProcessingHelper messageProcessingHelper;

	
	public SendTMessaggioDao getSendTMessaggioDao() {
		return sendTMessaggioDao;
	}
	public void setSendTMessaggioDao(SendTMessaggioDao sendTMessaggioDao) {
		this.sendTMessaggioDao = sendTMessaggioDao;
	}
	public MessageProcessingHelper getMessageProcessingHelper() {
		return messageProcessingHelper;
	}
	public void setMessageProcessingHelper(
			MessageProcessingHelper messageProcessingHelper) {
		this.messageProcessingHelper = messageProcessingHelper;
	}
	public PostgreSQLSequenceMaxValueIncrementer getSendTRichiestaDaoIncrementer() {
		return sendTRichiestaDaoIncrementer;
	}
	public void setSendTRichiestaDaoIncrementer(
			PostgreSQLSequenceMaxValueIncrementer sendTRichiestaDaoIncrementer) {
		this.sendTRichiestaDaoIncrementer = sendTRichiestaDaoIncrementer;
	}

	public SendTRichiestaDao getSendTRichiestaDao() {
		return sendTRichiestaDao;
	}
	public void setSendTRichiestaDao(SendTRichiestaDao sendTRichiestaDao) {
		this.sendTRichiestaDao = sendTRichiestaDao;
	}
	public SendDTipoCanaleDao getSendDTipoCanaleDao() {
		return sendDTipoCanaleDao;
	}
	public void setSendDTipoCanaleDao(SendDTipoCanaleDao sendDTipoCanaleDao) {
		this.sendDTipoCanaleDao = sendDTipoCanaleDao;
	}
	public SendTFruitoreDao getSendTFruitoreDao() {
		return sendTFruitoreDao;
	}
	public void setSendTFruitoreDao(SendTFruitoreDao sendTFruitoreDao) {
		this.sendTFruitoreDao = sendTFruitoreDao;
	}
	public SendRFruitoreCanaleDao getSendRFruitoreCanaleDao() {
		return sendRFruitoreCanaleDao;
	}
	public void setSendRFruitoreCanaleDao(
			SendRFruitoreCanaleDao sendRFruitoreCanaleDao) {
		this.sendRFruitoreCanaleDao = sendRFruitoreCanaleDao;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public SendTFruitoreDto findFruitore(String codiceFruitore) throws SendMessageException{
		String method = "findFruitore";
		SendTFruitoreDto sendTFruitoreDto = null;
		try{
			List<SendTFruitoreDto>  l = sendTFruitoreDao.findFindByCodFruitore(codiceFruitore);


			if(log.isDebugEnabled()){
				Tracer.debug(log,  getClass().getName(), method, "SendTFruitoreDto \n " + XmlSerializer.objectToXml(l));
			}
			if(l.size() == 0) throw new SendMessageException("Fruitore non censito in anagrafica");
			else if(l.size() == 1) {
				sendTFruitoreDto = l.get(0);
				Tracer.debug(log,  getClass().getName(), method, "Fruitore presente in anagrafica");
			}
			else{
				throw new SendMessageException("Troppi fruitori con lo stesso codice");
			}
		}
		catch (SendTFruitoreDaoException e){
			Tracer.error(log,  getClass().getName(), method, "SendTFruitoreDaoException " + e);
			throw new SendMessageException(e.getMessage());
		}

		return sendTFruitoreDto;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Map<String, SendDTipoCanaleDto> findCanaliAttiviFruitore(String codiceFruitore) throws SendMessageException{
		String method = "findCanaliAttiviFruitore";
		Map<String, SendDTipoCanaleDto> map = new  LinkedHashMap<String, SendDTipoCanaleDto>();

		List<SendDTipoCanaleDto> canaliAttiviAssociati;
		try {

			canaliAttiviAssociati = sendDTipoCanaleDao.findFindCanaliAttiviByFruitore(codiceFruitore);

			if(log.isDebugEnabled()){
				Tracer.debug(log,  getClass().getName(), method, "canaliAttiviAssociati \n " + XmlSerializer.objectToXml(canaliAttiviAssociati));
			}

			if(canaliAttiviAssociati.size() == 0) throw new SendMessageException("Nessun canale attivo associato al fruitore");

			for(SendDTipoCanaleDto dto : canaliAttiviAssociati){
				map.put(dto.getCodTipoCanale(), dto);
			}

			if(log.isDebugEnabled()){
				for(SendDTipoCanaleDto dto : canaliAttiviAssociati){
					Tracer.debug(log,  getClass().getName(), method, "canale associato al fruitore " + dto.getCodTipoCanale());
				}
			}
		} catch (SendDTipoCanaleDaoException e) {
			Tracer.error(log,  getClass().getName(), method, "SendDTipoCanaleDaoException " + e);
			throw new SendMessageException(e.getMessage());
		}

		return map;
	}


	@Transactional(propagation=Propagation.REQUIRED)
	public SendTRichiestaDto findSendTRichiestaByCodiceCodaJms(Integer idFruitore, String codiceCodaJms) throws SendMessageException{
		String method = "findSendTRichiestaByCodiceCodaJms";
		SendTRichiestaDto sendTRichiestaDto = null;

		try{
			List<SendTRichiestaDto> sendTRichiestas = getSendTRichiestaDao().findByFruitoreJmsRichiesta(idFruitore, codiceCodaJms);

			if(sendTRichiestas == null || sendTRichiestas.size() == 0){
				Tracer.debug(log,  getClass().getName(), method, "Nessuna richiesta " + codiceCodaJms + " per fruitore " + idFruitore);
			}
			else{
				Tracer.debug(log,  getClass().getName(), method, "Trovata richiesta...");
				sendTRichiestaDto = sendTRichiestas.get(0);
			}
		}
		catch (SendTRichiestaDaoException e){
			Tracer.error(log,  getClass().getName(), method, "SendTRichiestaDaoException " + e);
			throw new SendMessageException(e.getMessage());
		}

		return sendTRichiestaDto;
	}


	


	@Transactional(propagation=Propagation.REQUIRED)
	public void sendMessage(RequestMessage request, String codiceCodaJms) throws SendMessageException {
		String method = "sendMessage";
		try{
			if(log.isDebugEnabled()){
				Tracer.debug(log,  getClass().getName(), method, "codiceCodaJms= " + codiceCodaJms);
				Tracer.debug(log,  getClass().getName(), method, "request.toString()= " + request.toString());

				Tracer.debug(log,  getClass().getName(), method, "REQUEST \n " + XmlSerializer.objectToXml(request));
				Tracer.debug(log,  getClass().getName(), method, "caller= " + request.getCaller());
			}

			ResponseInsertMessageDto responseInsertMessageDto = null;

			if(StringUtils.isBlank(codiceCodaJms)) throw new SendMessageException("Codice coda non valorizzato");

			// recupero il fruitore
			SendTFruitoreDto sendTFruitoreDto = findFruitore(request.getCaller());

			// recupero i canali attivi per il fruitore
			Map<String, SendDTipoCanaleDto> tipoCanaleMap = findCanaliAttiviFruitore(request.getCaller());

			Tracer.debug(log,  getClass().getName(), method, "verifico se la richiesta � gi� stata inserita");

			SendTRichiestaDto sendTRichiestaDto = findSendTRichiestaByCodiceCodaJms(sendTFruitoreDto.getIdFruitore().intValue(), codiceCodaJms);

			if(sendTRichiestaDto == null ){

				Tracer.debug(log,  getClass().getName(), method, "richiesta da inserire...");
				responseInsertMessageDto = messageProcessingHelper.insertMessage(sendTFruitoreDto.getIdFruitore(), codiceCodaJms, tipoCanaleMap, request.getMessage());

			}
			else{

				SendTMessaggioDto sendTMessaggio = null;

				Tracer.debug(log,  getClass().getName(), method, "richiesta " + codiceCodaJms + " gi� presente per il fruitore: proviamo a rielaborare");
				Tracer.debug(log,  getClass().getName(), method, "richiesta " + sendTRichiestaDto.getIdRichiesta());

				List<SendTMessaggioDto> messaggiAssociatiRichiesta = getSendTMessaggioDao().findByIdRichiesta(sendTRichiestaDto.getIdRichiesta());

				if(messaggiAssociatiRichiesta != null){
					
					if(messaggiAssociatiRichiesta.size() > 0){
						sendTMessaggio = messaggiAssociatiRichiesta.get(0);
					}
				}

				responseInsertMessageDto = new ResponseInsertMessageDto();
				responseInsertMessageDto.setSendTMessaggio(sendTMessaggio);
				responseInsertMessageDto.setSendTRichiestaDto(sendTRichiestaDto);

			}

			if(request.getMessage()!= null){

				Message message = request.getMessage();

				Tracer.debug(log,  getClass().getName(), method, "pk message= " + message.getPk());
				if(responseInsertMessageDto.getSendTMessaggio() != null && 
						responseInsertMessageDto.getSendTMessaggio().getIdJmsMessaggio() != null && 
						responseInsertMessageDto.getSendTMessaggio().getIdJmsMessaggio().intValue() == message.getPk()){

					messageProcessingHelper.processMessage(sendTFruitoreDto.getIdFruitore().intValue(), responseInsertMessageDto, message);

				}

				else{
					Tracer.debug(log,  getClass().getName(), method, "Messaggio " + message.getPk() + " non presente nella lista dei messaggi da elaborare.");
				}

			}


		}
		catch(Exception e){
			Tracer.debug(log,  getClass().getName(), method, "Exception " + e);
			throw new SendMessageException(e.getMessage());
		}

	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void sendMessages(RequestMessages request, String codiceCodaJms) throws SendMessageException {
		String method = "sendMessages";
		try{
			if(log.isDebugEnabled()){
				Tracer.debug(log,  getClass().getName(), method, "codiceCodaJms= " + codiceCodaJms);
				Tracer.debug(log,  getClass().getName(), method, "request.toString()= " + request.toString());

				Tracer.debug(log,  getClass().getName(), method, "REQUEST \n " + XmlSerializer.objectToXml(request));
				Tracer.debug(log,  getClass().getName(), method, "caller= " + request.getCaller());
			}

			ResponseInsertMessagesDto responseInsertMessagesDto = null;

			if(StringUtils.isBlank(codiceCodaJms)) throw new SendMessageException("Codice coda non valorizzato");

			// recupero il fruitore
			SendTFruitoreDto sendTFruitoreDto = findFruitore(request.getCaller());

			// recupero i canali attivi per il fruitore
			Map<String, SendDTipoCanaleDto> tipoCanaleMap = findCanaliAttiviFruitore(request.getCaller());

			Tracer.debug(log,  getClass().getName(), method, "verifico se la richiesta � gi� stata inserita");

			SendTRichiestaDto sendTRichiestaDto = findSendTRichiestaByCodiceCodaJms(sendTFruitoreDto.getIdFruitore().intValue(), codiceCodaJms);

			if(sendTRichiestaDto == null ){

				Tracer.debug(log,  getClass().getName(), method, "richiesta da inserire...");
				responseInsertMessagesDto = messageProcessingHelper.insertMessages(sendTFruitoreDto.getIdFruitore(), codiceCodaJms, tipoCanaleMap,  Arrays.asList(request.getMessages()));

			}
			else{

				Tracer.debug(log,  getClass().getName(), method, "richiesta " + codiceCodaJms + " gi� presente per il fruitore: proviamo a rielaborare");
				Tracer.debug(log,  getClass().getName(), method, "richiesta " + sendTRichiestaDto.getIdRichiesta());

				List<SendTMessaggioDto> messaggiAssociatiRichiesta = getSendTMessaggioDao().findByIdRichiesta(sendTRichiestaDto.getIdRichiesta());

				responseInsertMessagesDto = new ResponseInsertMessagesDto();
				responseInsertMessagesDto.setSendTRichiestaDto(sendTRichiestaDto);
				for(SendTMessaggioDto dto :  messaggiAssociatiRichiesta){
					Tracer.debug(log,  getClass().getName(), method, "adding " + dto.getIdJmsMessaggio());
					responseInsertMessagesDto.getSendTMessageDtoMap().put(dto.getIdJmsMessaggio(), dto);
				}
			}

			if(request.getMessages() != null){
				messageProcessingHelper.processMessages(sendTFruitoreDto.getIdFruitore().intValue(), responseInsertMessagesDto, Arrays.asList(request.getMessages()));
			}
			else{
				throw new Exception("Nessun messaggio presente nella richiesta");
			}


		}
		catch(Exception e){
			Tracer.debug(log,  getClass().getName(), method, "Exception " + e);
			throw new SendMessageException(e.getMessage());
		}

	}

}