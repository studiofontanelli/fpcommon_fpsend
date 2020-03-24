package it.csi.fpcommon.fpsend.business.fpsend.helper;

import it.csi.fpcommon.fpsend.dto.fpsend.RequestMessage;
import it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;

public interface PecSenderHelper {
	
	
	/**
	 * 
	 * @param request
	 * @param codiceCodaJMS
	 * @throws SendMessageException
	 */
	public String sendMessage(RequestMessage request) throws SendMessageException;
	
	

}
