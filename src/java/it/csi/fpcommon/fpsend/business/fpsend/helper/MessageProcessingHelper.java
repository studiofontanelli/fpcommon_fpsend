package it.csi.fpcommon.fpsend.business.fpsend.helper;

import it.csi.fpcommon.fpsend.business.dao.fpsend.dto.SendDTipoCanaleDto;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;
import it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface MessageProcessingHelper {
	
	/**
	 * 
	 * @param sendTRichiestaDto
	 * @param message
	 * @throws SendMessageException
	 */
	public String processMessage(int idFruitore, ResponseInsertMessageDto responseInsertMessageDto, Message message) throws SendMessageException;
	
	
	/**
	 * 
	 * @param responseInsertMessagesDto
	 * @param messages
	 * @throws SendMessageException
	 */
	public void processMessages(int idFruitore,ResponseInsertMessagesDto responseInsertMessagesDto , List<Message> messages) throws SendMessageException;
	
	
	/**
	 * 
	 * @param idFruitore
	 * @param codiceCodaJms
	 * @param messages
	 * @throws SendMessageException
	 */
	public ResponseInsertMessagesDto insertMessages(BigDecimal idFruitore, String codiceCodaJms,  Map<String, SendDTipoCanaleDto> tipoCanaleMap, List<Message> messages) throws SendMessageException;
	
	
	/**
	 * 
	 * @param idFruitore
	 * @param codiceCodaJms
	 * @param tipoCanaleMap
	 * @param message
	 * @return
	 * @throws SendMessageException
	 */
	public ResponseInsertMessageDto insertMessage(BigDecimal idFruitore, String codiceCodaJms,  Map<String, SendDTipoCanaleDto> tipoCanaleMap,  Message message) throws SendMessageException;

}
