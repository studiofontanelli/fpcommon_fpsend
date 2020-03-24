package it.csi.fpcommon.fpsend.business.fpsend.helper.impl;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.SendDTipoCanaleDao;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.SendRFruitoreCanaleDao;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.SendTFruitoreDao;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.SendTMessaggioDao;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.SendTRichiestaDao;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendDTipoCanaleDto;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTFruitoreDto;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTRichiestaDto;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.SendDTipoCanaleDaoException;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.SendTFruitoreDaoException;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.SendTRichiestaDaoException;
import it.csi.fpcommon.fpsend.business.fpsend.helper.MessageProcessingHelper;
import it.csi.fpcommon.fpsend.business.fpsend.helper.PecSenderHelper;
import it.csi.fpcommon.fpsend.business.fpsend.helper.ResponseInsertMessageDto;
import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.business.util.XmlSerializer;
import it.csi.fpcommon.fpsend.dto.fpsend.RequestMessage;
import it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.support.incrementer.PostgreSQLSequenceMaxValueIncrementer;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class PecSenderHelperImpl implements PecSenderHelper {


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

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String sendMessage(RequestMessage request) throws SendMessageException {
		String method = "sendMessage";
		String result = null;
		boolean fruitoreAbilitato = false;
		try{
			

			ResponseInsertMessageDto responseInsertMessageDto = null;
			if(request == null){
				throw new SendMessageException("Valorizzare la request");
			}
			if(StringUtils.isBlank(request.getCaller())){
				throw new SendMessageException("Valorizzare il caller");
			}
			if(request.getMessage() == null){
				throw new SendMessageException("Valorizzare il Messaggio da inviare");
			}

			// recupero il fruitore
			SendTFruitoreDto sendTFruitoreDto = findFruitore(request.getCaller());

			// recupero i canali attivi per il fruitore
			Map<String, SendDTipoCanaleDto> tipoCanaleMap = findCanaliAttiviFruitore(request.getCaller());
			
			for(String key :tipoCanaleMap.keySet()){
				Tracer.debug(log,  getClass().getName(), method, "key= " + key);
				if(StringUtils.equals(key, request.getMessage().getChannel())){
					Tracer.debug(log,  getClass().getName(), method, "il fruitore può inviare un messagio di tipo " + key);
					fruitoreAbilitato = true;
				}
			}
			if(!fruitoreAbilitato){
				String message = "Fruitore non abilitato all'invio di messaggi di tipo " + request.getMessage().getChannel();
				throw new SendMessageException(message);			
			}
			
			Tracer.debug(log,  getClass().getName(), method, "richiesta da inserire...");
			responseInsertMessageDto = messageProcessingHelper.insertMessage(sendTFruitoreDto.getIdFruitore(), null, tipoCanaleMap, request.getMessage());
			
			
			/*
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
			 */

			Tracer.debug(log,  getClass().getName(), method, "pk message= " + request.getMessage().getPk());
			
			result = messageProcessingHelper.processMessage(sendTFruitoreDto.getIdFruitore().intValue(), responseInsertMessageDto, request.getMessage());
			
			
			
			

			

		}
		catch(Exception e){
			Tracer.debug(log,  getClass().getName(), method, "Exception " + e);
			throw new SendMessageException(e.getMessage());
		}
		return result;
	}




	

	

}