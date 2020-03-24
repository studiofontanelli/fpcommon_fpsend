package it.csi.fpcommon.fpsend.business.fpsend.integration;

import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.MessageProviderRequest;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.MessageProviderResponse;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.ProviderResponse;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;
import it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;

public interface MessageProvider {
	
	/**
	 * 
	 * @param sendTRichiestaDto
	 * @param message
	 * @throws SendMessageException
	 */
	public ProviderResponse execute(Message message) throws SendMessageException;
	
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public MessageProviderResponse execute(MessageProviderRequest request);
	

}
