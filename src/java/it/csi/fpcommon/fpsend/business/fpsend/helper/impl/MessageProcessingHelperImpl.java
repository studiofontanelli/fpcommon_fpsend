package it.csi.fpcommon.fpsend.business.fpsend.helper.impl;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.SendTMessaggioDao;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.SendTRichiestaDao;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dao.SendTTemplateDao;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendDTipoCanaleDto;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTMessaggioDto;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTMessaggioPk;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTRichiestaDto;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTRichiestaPk;
import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendTTemplateDto;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.SendTMessaggioDaoException;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.SendTRichiestaDaoException;
import it.csi.fpcommon.fpsend.business.dao.fpsend.exceptions.SendTTemplateDaoException;
import it.csi.fpcommon.fpsend.business.fpsend.helper.MessageProcessingHelper;
import it.csi.fpcommon.fpsend.business.fpsend.helper.ResponseInsertMessageDto;
import it.csi.fpcommon.fpsend.business.fpsend.helper.ResponseInsertMessagesDto;
import it.csi.fpcommon.fpsend.business.fpsend.integration.MessageProvider;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.MessageProviderRequest;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.MessageProviderResponse;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.ProviderResponse;
import it.csi.fpcommon.fpsend.business.fpsend.spring.JunitSpringBeanLocator;
import it.csi.fpcommon.fpsend.business.fpsend.spring.SpringBeanLocator;
import it.csi.fpcommon.fpsend.business.util.DateFormat;
import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.business.util.XmlSerializer;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;
import it.csi.fpcommon.fpsend.dto.fpsend.PlaceHolder;
import it.csi.fpcommon.fpsend.exception.fpsend.CommandException;
import it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;
import it.csi.fpcommon.fpsend.interfacecsi.fpsend.FpsendSrv;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.support.incrementer.PostgreSQLSequenceMaxValueIncrementer;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.PropertyPlaceholderHelper;


public class MessageProcessingHelperImpl implements MessageProcessingHelper {


	private static final int STATO_RICHIESTA_DA_ELABORARE    = 1;
	private static final int STATO_RICHIESTA_ELABORATA       = 2;
	private static final int STATO_RICHIESTA_SCARTATA        = 3;
	private static final int STATO_RICHIESTA_ERRORE          = 4;
	
	public static final Integer STATO_MESSAGGIO_DA_ELABORARE    = new Integer(1);
	public static final Integer STATO_MESSAGGIO_ELABORATO       = new Integer(2);
	public static final Integer STATO_MESSAGGIO_SCARTATO        = new Integer(3);


	public static final String LOGGER_PREFIX = "stasend.helper";

	private static Logger log = Logger.getLogger(LOGGER_PREFIX);

	// DAO
	private SendTRichiestaDao sendTRichiestaDao;
	private SendTMessaggioDao sendTMessaggioDao;
	private SendTTemplateDao sendTTemplateDao;


	public SendTTemplateDao getSendTTemplateDao() {
		return sendTTemplateDao;
	}

	public void setSendTTemplateDao(SendTTemplateDao sendTTemplateDao) {
		this.sendTTemplateDao = sendTTemplateDao;
	}

	// SEQUENCE
	private PostgreSQLSequenceMaxValueIncrementer sendTRichiestaDaoIncrementer;
	private PostgreSQLSequenceMaxValueIncrementer sendTMessaggioDaoIncrementer;


	// COMMANDS

	private Map<String, String> commands;

	public Map<String, String> getCommands() {
		return commands;
	}

	public void setCommands(Map<String, String> commands) {
		this.commands = commands;
	}



	public SendTMessaggioDao getSendTMessaggioDao() {
		return sendTMessaggioDao;
	}
	public void setSendTMessaggioDao(SendTMessaggioDao sendTMessaggioDao) {
		this.sendTMessaggioDao = sendTMessaggioDao;
	}
	public PostgreSQLSequenceMaxValueIncrementer getSendTMessaggioDaoIncrementer() {
		return sendTMessaggioDaoIncrementer;
	}
	public void setSendTMessaggioDaoIncrementer(PostgreSQLSequenceMaxValueIncrementer sendTMessaggioDaoIncrementer) {
		this.sendTMessaggioDaoIncrementer = sendTMessaggioDaoIncrementer;
	}

	public SendTRichiestaDao getSendTRichiestaDao() {
		return sendTRichiestaDao;
	}
	public void setSendTRichiestaDao(SendTRichiestaDao sendTRichiestaDao) {
		this.sendTRichiestaDao = sendTRichiestaDao;
	}
	public PostgreSQLSequenceMaxValueIncrementer getSendTRichiestaDaoIncrementer() {
		return sendTRichiestaDaoIncrementer;
	}
	public void setSendTRichiestaDaoIncrementer(PostgreSQLSequenceMaxValueIncrementer sendTRichiestaDaoIncrementer) {
		this.sendTRichiestaDaoIncrementer = sendTRichiestaDaoIncrementer;
	}


	public SendTTemplateDto getSendTTemplateDto(int idFruitore, String codTemplate) throws SendMessageException{
		String method = "getSendTTemplateDto";
		SendTTemplateDto sendTTemplateDto = null;
		try {
			Tracer.debug(log,  getClass().getName(), method, "loading template " + codTemplate);
			List<SendTTemplateDto> sendTTemplateList = getSendTTemplateDao().findByCodTemplate(idFruitore,codTemplate);
			if(sendTTemplateList != null && sendTTemplateList.size() == 1){
				Tracer.debug(log,  getClass().getName(), method, "Trovato TEMPLATE " + codTemplate + " per fruitore " +idFruitore);
				sendTTemplateDto = sendTTemplateList.get(0);
			}
			else{
				throw new SendMessageException ("Template " +  codTemplate  + " non configurato!");
			}
		} catch (SendTTemplateDaoException e) {
			Tracer.debug(log,  getClass().getName(), method, "SendTTemplateDaoException " + e);
			throw new SendMessageException(e.getMessage());
		}
		return sendTTemplateDto;
	}


	public void manageTemplate( int idFruitore, Message message) throws SendMessageException, SendTTemplateDaoException {
		String method = "manageTemplate";

		if(message.getTemplate() != null && StringUtils.isNotBlank(message.getTemplate().getCode()) ) {

			SendTTemplateDto sendTTemplateDto = getSendTTemplateDto(idFruitore, message.getTemplate().getCode());
			
			String testoTemplate = sendTTemplateDto.getTestoTemplate();
			String testoMessaggio = null;
			String oggettoMessaggio = sendTTemplateDto.getOggettoTemplate();
			
			if(log.isDebugEnabled()){
				Tracer.debug(log,  getClass().getName(), method, "oggettoMessaggio= " + oggettoMessaggio);
			}
			//
			
			if(StringUtils.isNotBlank(oggettoMessaggio)){
				message.setSubject(oggettoMessaggio);
			}
			
			

			if(message.getTemplate().getPlaceHolders() != null){

				Properties properties = new Properties();
				PropertyPlaceholderHelper placeHolderHelper = new PropertyPlaceholderHelper("{", "}");

				for(int i=0; i<message.getTemplate().getPlaceHolders().length; i++){
					PlaceHolder ph = message.getTemplate().getPlaceHolders()[i];
					Tracer.debug(log,  getClass().getName(), method, "placeHolder {" + ph.getKey() + "}= " + ph.getValue());
					if(StringUtils.isNotBlank(ph.getKey()) ){
						if(StringUtils.isNotBlank(ph.getValue()) ){
							if(StringUtils.equals(FpsendSrv.EMPTY_PLACE_HOLDER, ph.getValue())){
								Tracer.debug(log,  getClass().getName(), method, "intercattato empty place holder: forzo un blank");
								properties.setProperty(ph.getKey(), "");
							}
							else{
								properties.setProperty(ph.getKey(), ph.getValue());
							}
							
						}
						else{
							Tracer.warn(log,  getClass().getName(), method, "placeHolder " + ph.getKey()  + " non valorizzato!");
						}
					}
					else{
						throw new SendMessageException ("Placeholder " + ph.getKey() + " non valorizzato correttamente");
					}
					
				}

				testoMessaggio = placeHolderHelper.replacePlaceholders(testoTemplate, properties);
				//Tracer.debug(log,  getClass().getName(), method, "testoMessaggio= " + testoMessaggio);
				message.setBody(testoMessaggio);
			}
			else{
				throw new SendMessageException ("Nessun placeholder presente nel template");
			}

		}
		else{
			Tracer.debug(log,  getClass().getName(), method, "Template non valorizzato");
		}
	}


	protected MessageProvider findCommand(String cmdId) throws CommandException {
		String method = "findCommand";
		if(log.isDebugEnabled()){
			Tracer.debug(log, getClass().getName(), method, "cmdId= " + cmdId);
		}
		MessageProvider command = null;
		String beanId = MapUtils.getString(commands, cmdId);
		if(log.isDebugEnabled()){
			Tracer.debug(log, getClass().getName(), method, "beanId= " + beanId);
		}

		if(StringUtils.isNotBlank(beanId)){
			command = (MessageProvider)SpringBeanLocator.getBean(beanId);
			Tracer.debug(log,  getClass().getName(), method, "command= " + command);
			if(command == null){
				Tracer.error(log,  getClass().getName(), method, "JUNIT...");
				command = (MessageProvider)JunitSpringBeanLocator.getBean(beanId);
				Tracer.error(log,  getClass().getName(), method, "command JUNIT= " + command);
			}
		}		
		else{
			String message = "Command " + cmdId + " not found";
			Tracer.debug(log, getClass().getName(), method, message);
			throw new CommandException(message);
		}


		return command;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void changeStatus(SendTMessaggioDto sendTMessaggioDto, Integer newStatus) throws SendTMessaggioDaoException{
		String method = "changeStatus";
		Tracer.debug(log,  getClass().getName(), method, "new status for message [" + sendTMessaggioDto.getIdMessaggio() + "] = " + newStatus);
		try{
			sendTMessaggioDto.setDataAggiornamento(DateFormat.getCurrentTimestampDate());
			sendTMessaggioDto.setIdStatoMessaggio(newStatus);
			sendTMessaggioDao.updateColumnsStatoMessaggio(sendTMessaggioDto);
		}
		finally{
			Tracer.debug(log,  getClass().getName(), method, "status change correctly!");
		}

	}
	
	
	//@Transactional(propagation=Propagation.REQUIRED)
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void changeStatusMessages(List<SendTMessaggioDto> sendTMessaggioDtoList, Integer newStatus) throws SendTMessaggioDaoException, SendMessageException{
		String method = "changeStatusMessages";
		Tracer.debug(log,  getClass().getName(), method, "BEGIN");
		if(sendTMessaggioDtoList == null) throw new SendMessageException("sendTMessaggioDtoList is null");
		
		Tracer.debug(log,  getClass().getName(), method, "new status for message [" + sendTMessaggioDtoList.size() + "] messages ");
		try{
			
			StringBuffer in = new StringBuffer();
			in.append("( ");
			for(int i= 0; i<sendTMessaggioDtoList.size(); i++){
				SendTMessaggioDto dto = sendTMessaggioDtoList.get(i);
				
				in.append(dto.getIdMessaggio());
				if(i<sendTMessaggioDtoList.size()-1) in.append(", ");
			}
			in.append("  )");
			
			if(log.isDebugEnabled()){
				Tracer.debug(log,  getClass().getName(), method, "in " + in.toString() );
			}
			
			sendTMessaggioDao.customUpdaterUpdateStato(in.toString(), newStatus);
			Tracer.debug(log,  getClass().getName(), method, "status change correctly!");
			
		}
		finally{
			
			Tracer.debug(log,  getClass().getName(), method, "END");
		}

	}

	//@Transactional(propagation=Propagation.REQUIRED)
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void changeStatus(SendTRichiestaDto sendTRichiestaDto, Integer newStatus) throws SendTRichiestaDaoException{
		String method = "changeStatus";
		Tracer.debug(log,  getClass().getName(), method, "new status for richiesta [" + sendTRichiestaDto.getIdRichiesta() + "] = " + newStatus);
		try{

			sendTRichiestaDto.setIdStatoRichiesta(newStatus);
			sendTRichiestaDao.updateColumnsStatoRichiesta(sendTRichiestaDto);
		}
		finally{
			Tracer.debug(log,  getClass().getName(), method, "status change correctly!");
		}

	}

	@Transactional(propagation=Propagation.REQUIRED)
	public String processMessage(int idFruitore, ResponseInsertMessageDto responseInsertMessageDto, Message message) throws SendMessageException {

		String method = "processMessage";
		String result = null;
		try{
			Tracer.debug(log,  getClass().getName(), method, "message channel= " + message.getChannel());

			manageTemplate(idFruitore, message);

			ProviderResponse providerResonse = findCommand(message.getChannel()).execute(message);
			if(providerResonse != null)
				result = providerResonse.getResult();

			changeStatus(responseInsertMessageDto.getSendTMessaggio(), STATO_MESSAGGIO_ELABORATO);
			changeStatus(responseInsertMessageDto.getSendTRichiestaDto(), STATO_RICHIESTA_ELABORATA);
		}
		catch(CommandException e){
			try{
				Tracer.error(log,  getClass().getName(), method, "CommandException " + e);
				changeStatus(responseInsertMessageDto.getSendTMessaggio(), STATO_MESSAGGIO_SCARTATO);
				changeStatus(responseInsertMessageDto.getSendTRichiestaDto(), STATO_RICHIESTA_ERRORE);
			}
			catch(SendTMessaggioDaoException ex){
				Tracer.error(log,  getClass().getName(), method, "SendTMessaggioDaoException " + ex);
				throw new SendMessageException(ex.getMessage());
			}
			catch(SendTRichiestaDaoException ex){
				Tracer.error(log,  getClass().getName(), method, "SendTRichiestaDaoException " + ex);
				throw new SendMessageException(ex.getMessage());
			}
		}
		catch(SendMessageException e){
			try{
				Tracer.error(log,  getClass().getName(), method, "SendMessageException " + e);
				changeStatus(responseInsertMessageDto.getSendTMessaggio(), STATO_MESSAGGIO_SCARTATO);
				changeStatus(responseInsertMessageDto.getSendTRichiestaDto(), STATO_RICHIESTA_ERRORE);
			}
			catch(SendTMessaggioDaoException ex){
				Tracer.error(log,  getClass().getName(), method, "SendTMessaggioDaoException " + ex);
				throw new SendMessageException(ex.getMessage());
			}
			catch(SendTRichiestaDaoException ex){
				Tracer.error(log,  getClass().getName(), method, "SendTRichiestaDaoException " + ex);
				throw new SendMessageException(ex.getMessage());
			}
		}

		catch(Exception e){
			Tracer.error(log,  getClass().getName(), method, "Exception " + e);
			throw new SendMessageException(e.getMessage());
		}
		return result;


	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void processMessages(int idFruitore, ResponseInsertMessagesDto responseInsertMessagesDto , List<Message> messages) throws SendMessageException {
		String method = "processMessages";
		try{

			Integer newIdStatoRichiesta = STATO_RICHIESTA_ELABORATA; // se tutto va bene ovviamente!
			
			Map <String, MessageProviderRequest> requestMap = new LinkedHashMap<String, MessageProviderRequest>();
			
			if(log.isDebugEnabled()){
				Tracer.debug(log,  getClass().getName(), method, "processing " + messages.size() + " messages");
			}

			for(Message message : messages){
				Tracer.debug(log,  getClass().getName(), method, "pk= " + message.getPk());
				if(responseInsertMessagesDto.getSendTMessageDtoMap().containsKey(message.getPk())){
					Tracer.debug(log,  getClass().getName(), method, "messaggio " + message.getPk()  + " da inviare!");
					try{
						
						// merge de messaggio col suo template
						manageTemplate(idFruitore, message);
						
						if(!requestMap.containsKey(message.getChannel())){
							Tracer.debug(log,  getClass().getName(), method, "aggiungo un canale di invio messaggio " + message.getChannel());
							requestMap.put(message.getChannel(), new MessageProviderRequest(message.getChannel()));
						}
						
						requestMap.get(message.getChannel()).getMessages().add(message);
						requestMap.get(message.getChannel()).getSendTMessagesMap().put(message.getPk()+"", responseInsertMessagesDto.getSendTMessageDtoMap().get(message.getPk())) ;  
						
					}
					catch(Exception e){
						Tracer.error(log,  getClass().getName(), method, "Exception " +e);
						changeStatus(responseInsertMessagesDto.getSendTMessageDtoMap().get(message.getPk()), STATO_MESSAGGIO_SCARTATO);
					}
				}
			}
			
			Tracer.debug(log,  getClass().getName(), method, "requestMap " + requestMap);

			for(Iterator<String> it = requestMap.keySet().iterator(); it.hasNext();){

				String channel = it.next();
				Tracer.debug(log,  getClass().getName(), method, "sending message for channel " + channel);
				
				MessageProviderResponse response = findCommand(channel).execute(requestMap.get(channel));
				
				if(newIdStatoRichiesta == STATO_RICHIESTA_ELABORATA){
					newIdStatoRichiesta = response.isContainError() ? STATO_RICHIESTA_ERRORE : STATO_RICHIESTA_ELABORATA;	
				}
				for(Iterator<Integer> itStatus = response.getSendTMessaggiByStatusMap().keySet().iterator(); itStatus.hasNext();){
					
					Integer statoMessaggiToUpdate = itStatus.next();
					List<SendTMessaggioDto> messaggiDaAggiornare = response.getSendTMessaggiByStatusMap().get(statoMessaggiToUpdate);

					Tracer.debug(log,  getClass().getName(), method, "ci sono " + messaggiDaAggiornare.size()   + " messaggi da portare in stato " + statoMessaggiToUpdate);
					
					changeStatusMessages(response.getSendTMessaggiByStatusMap().get(statoMessaggiToUpdate), statoMessaggiToUpdate);
					
				}
				
				Tracer.debug(log,  getClass().getName(), method, "processing message for channel " + channel + " completed!");
			}

			changeStatus(responseInsertMessagesDto.getSendTRichiestaDto(), newIdStatoRichiesta);

		}


		catch(Exception e){
			Tracer.error(log,  getClass().getName(), method, "Exception " + e);

			try{
				Tracer.error(log,  getClass().getName(), method, "SendMessageException " + e);

				changeStatus(responseInsertMessagesDto.getSendTRichiestaDto(), STATO_RICHIESTA_ERRORE);
			}
			catch(SendTRichiestaDaoException ex){
				Tracer.error(log,  getClass().getName(), method, "SendTRichiestaDaoException " + ex);
				throw new SendMessageException(ex.getMessage());
			}
			throw new SendMessageException(e.getMessage());
		}

	}


	//@Transactional(propagation=Propagation.REQUIRED)
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public ResponseInsertMessagesDto insertMessages(BigDecimal idFruitore, String codiceCodaJms, Map<String, SendDTipoCanaleDto> tipoCanaleMap, List<Message> messages) throws SendMessageException {

		String method = "insertMessages";

		ResponseInsertMessagesDto response = new ResponseInsertMessagesDto();
		Map<Integer, SendTMessaggioDto> sendTMessageDtoMap = new  LinkedHashMap<Integer, SendTMessaggioDto>();

		Tracer.debug(log,  getClass().getName(), method, "richiesta da inserire nella base dati");

		SendTRichiestaDto sendTRichiestaDto  = new SendTRichiestaDto();
		sendTRichiestaDto.setIdFruitore(idFruitore);
		sendTRichiestaDto.setIdRichiesta(sendTRichiestaDaoIncrementer.nextIntValue());
		sendTRichiestaDto.setIdJmsRichiesta(codiceCodaJms);
		sendTRichiestaDto.setIdStatoRichiesta(STATO_RICHIESTA_DA_ELABORARE); 

		SendTRichiestaPk sendTRichiestaPk =  getSendTRichiestaDao().insert(sendTRichiestaDto);

		Tracer.debug(log,  getClass().getName(), method, "inserita richiesta " + sendTRichiestaPk.getIdRichiesta());

		response.setSendTRichiestaDto(sendTRichiestaDto);
		response.setSendTMessageDtoMap(sendTMessageDtoMap);

		for(Message message : messages){

			if(tipoCanaleMap.containsKey(message.getChannel())){

				SendTMessaggioDto dto = new SendTMessaggioDto();
				
				if(message.getTemplate() != null && message.getTemplate().getCode() != null){
					SendTTemplateDto sendTTemplateDto = getSendTTemplateDto(idFruitore.intValue(), message.getTemplate().getCode());
					dto.setIdTemplate(sendTTemplateDto.getIdTemplate());
				} 
				
				dto.setIdRichiesta(sendTRichiestaPk.getIdRichiesta());
				dto.setDataInserimento(DateFormat.getCurrentTimestampDate());
				dto.setIdentMessaggioFruitore(message.getCallerInternalCode());
				dto.setIdJmsMessaggio(message.getPk());
				dto.setIdTipoCanale(tipoCanaleMap.get(message.getChannel()).getIdTipoCanale());
				dto.setIdMessaggio(sendTMessaggioDaoIncrementer.nextIntValue());
				dto.setIdStatoMessaggio(STATO_MESSAGGIO_DA_ELABORARE);

				SendTMessaggioPk sendTMessaggioPk =  getSendTMessaggioDao().insert(dto);

				Tracer.debug(log,  getClass().getName(), method, "inserito messaggio " + sendTMessaggioPk.getIdMessaggio());

				sendTMessageDtoMap.put(dto.getIdJmsMessaggio(), dto);


			}
			else{
				Tracer.debug(log,  getClass().getName(), method, "canale '" + message.getChannel() + "' non gestito per il fruitore " + idFruitore);
			}	
		}

		return response;
	}


	//@Transactional(propagation=Propagation.REQUIRED)
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public SendTRichiestaDto insertSendTRichiesta(BigDecimal idFruitore, String codiceCodaJms) throws SendMessageException{
		
		String method = "insertSendTRichiesta";
		SendTRichiestaDto sendTRichiestaDto  = new SendTRichiestaDto();
		sendTRichiestaDto.setIdFruitore(idFruitore);
		sendTRichiestaDto.setIdRichiesta(sendTRichiestaDaoIncrementer.nextIntValue());
		sendTRichiestaDto.setIdJmsRichiesta(codiceCodaJms);
		sendTRichiestaDto.setIdStatoRichiesta(STATO_RICHIESTA_DA_ELABORARE); 
		if(log.isDebugEnabled()){
			Tracer.debug(log,  getClass().getName(), method, "inserimento richiesta " + XmlSerializer.objectToXml(sendTRichiestaDto));
		}
		
		SendTRichiestaPk sendTRichiestaPk =  getSendTRichiestaDao().insert(sendTRichiestaDto);
		Tracer.debug(log,  getClass().getName(), method, "inserita richiesta " + sendTRichiestaPk.getIdRichiesta());
		return sendTRichiestaDto;

	}


	//@Transactional(propagation=Propagation.REQUIRED)
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public SendTMessaggioDto insertSendTMessaggio(int idFruitore, SendTRichiestaDto sendTRichiestaDto, Message message, Integer idTipoCanale) throws SendMessageException{

		String method = "insertSendTMessaggio";
		
		SendTMessaggioDto dto = new SendTMessaggioDto();
		
		if(message.getTemplate() != null && message.getTemplate().getCode() != null){
			SendTTemplateDto sendTTemplateDto = getSendTTemplateDto(idFruitore, message.getTemplate().getCode());
			dto.setIdTemplate(sendTTemplateDto.getIdTemplate());
		} 
		
		dto.setIdRichiesta(sendTRichiestaDto.getIdRichiesta());
		dto.setDataInserimento(DateFormat.getCurrentTimestampDate());
		dto.setIdentMessaggioFruitore(StringUtils.substring(message.getCallerInternalCode(), 0, 100));
		dto.setIdJmsMessaggio(message.getPk());
		dto.setIdTipoCanale(idTipoCanale);
		dto.setIdMessaggio(sendTMessaggioDaoIncrementer.nextIntValue());
		dto.setIdStatoMessaggio(STATO_MESSAGGIO_DA_ELABORARE);

		SendTMessaggioPk sendTMessaggioPk =  getSendTMessaggioDao().insert(dto);

		Tracer.debug(log,  getClass().getName(), method, "inserito messaggio " + sendTMessaggioPk.getIdMessaggio());

		return dto;

	}

	@Transactional(propagation=Propagation.REQUIRED)
	public ResponseInsertMessageDto insertMessage(BigDecimal idFruitore, String codiceCodaJms, Map<String, SendDTipoCanaleDto> tipoCanaleMap, Message message) throws SendMessageException {

		String method = "insertMessage";
		ResponseInsertMessageDto response = new ResponseInsertMessageDto();
		try{

			SendTRichiestaDto sendTRichiestaDto = insertSendTRichiesta(idFruitore, codiceCodaJms);
			response.setSendTRichiestaDto(sendTRichiestaDto);

			if(tipoCanaleMap.containsKey(message.getChannel())){			

				SendTMessaggioDto sendTMessaggio = insertSendTMessaggio(idFruitore.intValue(), sendTRichiestaDto, message, tipoCanaleMap.get(message.getChannel()).getIdTipoCanale());
				response.setSendTMessaggio(sendTMessaggio);

			}
			else{
				Tracer.error(log,  getClass().getName(), method, "canale '" + message.getChannel() + "' non gestito per il fruitore " + idFruitore);
				changeStatus(response.getSendTRichiestaDto(), STATO_RICHIESTA_SCARTATA);
			}	
		}
		catch(SendTRichiestaDaoException e){
			Tracer.error(log,  getClass().getName(), method, "SendTRichiestaDaoException " + e);
			throw new SendMessageException(e.getMessage());
		}

		return response;
	}


}