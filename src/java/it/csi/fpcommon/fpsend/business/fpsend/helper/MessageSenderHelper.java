package it.csi.fpcommon.fpsend.business.fpsend.helper;

import it.csi.fpcommon.fpsend.dto.fpsend.RequestMessage;
import it.csi.fpcommon.fpsend.dto.fpsend.RequestMessages;
import it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;

public interface MessageSenderHelper {
	
	
	/**
	 * 
	 * @param request
	 * @param codiceCodaJMS
	 * @throws SendMessageException
	 */
	public void sendMessage(RequestMessage request, String codiceCodaJMS) throws SendMessageException;
	
	
	/**
	 * 
	 * @param request
	 * @param codiceCodaJMS
	 * @throws SendMessageException
	 */
	public void sendMessages(RequestMessages request, String codiceCodaJMS) throws SendMessageException;

}
