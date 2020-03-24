package it.csi.fpcommon.fpsend.business.fpsend.integration.impl;

import it.csi.fpcommon.fpsend.business.fpsend.integration.MessageProvider;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.ProviderResponse;
import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;
import it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

public class MockPecMessageProviderImpl extends PecMessageProviderImpl implements MessageProvider{

	public static final String LOGGER_PREFIX = "stasend.integration";
	private static Logger log = Logger.getLogger(LOGGER_PREFIX);
	

	public ProviderResponse execute(Message message) throws SendMessageException {

		final String method = "execute";
		
		ProviderResponse response = new ProviderResponse();
		if(log.isDebugEnabled()){
			Tracer.debug(log, getClass().getName(), method, "from     = " + message.getSender());
			Tracer.debug(log, getClass().getName(), method, "to       = " + message.getRecipient());
			Tracer.debug(log, getClass().getName(), method, "subject  = " + message.getSubject());
			Tracer.debug(log, getClass().getName(), method, "body     = " + message.getBody());
			Tracer.debug(log, getClass().getName(), method, "smtp     = " + getSmtp());
			Tracer.debug(log, getClass().getName(), method, "userId     = " + getUserId());
			Tracer.debug(log, getClass().getName(), method, "pwd     = " + getPassword());
		}
		try{
			String val = RandomStringUtils.randomAlphabetic(10);
	        response.setResult(val);
			Tracer.info(log, getClass().getName(), method, "*** Mock pec ***  " + response.getResult() + " generata correttamente");
		}
		catch(Exception e){
			Tracer.error(log, getClass().getName(), method, "Exception  = " + e);
			throw new SendMessageException(e.getMessage());
		}
		catch(Throwable e){
			Tracer.error(log, getClass().getName(), method, "Throwable  = " + e);
			throw new SendMessageException(e.getMessage());
		}
		return response;

	}

}
