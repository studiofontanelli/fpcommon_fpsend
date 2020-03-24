package it.csi.fpcommon.fpsend.business.fpsend.integration.impl;

import it.csi.fpcommon.fpsend.business.fpsend.integration.MessageProvider;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.ProviderResponse;
import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;
import it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;

import org.apache.log4j.Logger;

public class MockEmailMessageProviderImpl extends  EmailMessageProviderImpl implements MessageProvider{

	public static final String LOGGER_PREFIX = "stasend.integration";

	private static Logger log = Logger.getLogger(LOGGER_PREFIX);

	public ProviderResponse execute(Message message) throws SendMessageException {

		String method = "execute";
		
		ProviderResponse response = null;
		
		if(log.isDebugEnabled()){
			Tracer.debug(log, getClass().getName(), method, "from     = " + message.getSender());
			Tracer.debug(log, getClass().getName(), method, "to       = " + message.getRecipient());
			Tracer.debug(log, getClass().getName(), method, "subject  = " + message.getSubject());
			Tracer.debug(log, getClass().getName(), method, "body     = " + message.getBody());
		}
		try{

			
			
			Tracer.info(log, getClass().getName(), method, "Nessuna email e' stata inviata!");
		}
		catch(Exception e){
			Tracer.error(log, getClass().getName(), method, "Exception  = " + e);
			throw new SendMessageException(e.getMessage());
		}
		return response;
	}

}
