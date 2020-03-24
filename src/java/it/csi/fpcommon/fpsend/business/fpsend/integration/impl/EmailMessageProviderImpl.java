package it.csi.fpcommon.fpsend.business.fpsend.integration.impl;

import it.csi.fpcommon.fpsend.business.fpsend.helper.impl.MessageProcessingHelperImpl;
import it.csi.fpcommon.fpsend.business.fpsend.integration.MessageProvider;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.MessageProviderRequest;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.MessageProviderResponse;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.ProviderResponse;
import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;
import it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;

import java.io.ByteArrayInputStream;

import javax.mail.internet.MimeMessage;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailMessageProviderImpl  implements MessageProvider{

	public static final String LOGGER_PREFIX = "stasend.integration";

	private static Logger log = Logger.getLogger(LOGGER_PREFIX);

	private JavaMailSender mailSender = null;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMessage(MimeMessage simpleMailMessage){
		String method = "sendMessage";
		Tracer.debug(log, getClass().getName(), method, "sending mail...");
		mailSender.send(simpleMailMessage);
	}

	public ProviderResponse execute(Message message) throws SendMessageException {

		String method = "execute";
		if(log.isDebugEnabled()){
			Tracer.debug(log, getClass().getName(), method, "from     = " + message.getSender());
			Tracer.debug(log, getClass().getName(), method, "to       = " + message.getRecipient());
			Tracer.debug(log, getClass().getName(), method, "subject  = " + message.getSubject());
			Tracer.debug(log, getClass().getName(), method, "body     = " + message.getBody());
		}
		ProviderResponse response = null;
		try{

			//SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper simpleMailMessage = new MimeMessageHelper(mail,true);
			
			simpleMailMessage.setFrom(message.getSender());
			
			if(null!=message.getRecipient())
				simpleMailMessage.setTo(message.getRecipient());
			else
			simpleMailMessage.setTo(message.getRecipients());
			
			simpleMailMessage.setSubject(message.getSubject());
			simpleMailMessage.setText(message.getBody());			
			if(null!=message.getAttachment())
				simpleMailMessage.addAttachment(message.getAttachment().getName(), new ByteArrayResource(IOUtils.toByteArray(new ByteArrayInputStream(message.getAttachment().getAttachment()))));
			
			sendMessage(mail);
			
			Tracer.debug(log, getClass().getName(), method, "mail inviata correttamente!");
		}
		catch(Exception e){
			Tracer.error(log, getClass().getName(), method, "Exception  = " + e);
			throw new SendMessageException(e.getMessage());
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * @see it.csi.stacore.stasend.business.stasend.integration.MessageProvider#execute(it.csi.stacore.stasend.business.stasend.integration.dto.MessageProviderRequest)
	 */
	public  MessageProviderResponse execute( MessageProviderRequest request) {
		String method = "execute";
		
		MessageProviderResponse response = new MessageProviderResponse(request.getChannel(), request.getMessages(), request.getSendTMessagesMap());
		
		for(Message  message : request.getMessages()){
			try{
				
				execute(message);
				response.addSendTMessaggioToStatusMap(MessageProcessingHelperImpl.STATO_MESSAGGIO_ELABORATO, response.getSendTMessaggioDtoByMessage(message));
				
			}
			catch(SendMessageException e){
				response.addSendTMessaggioToStatusMap(MessageProcessingHelperImpl.STATO_MESSAGGIO_SCARTATO, response.getSendTMessaggioDtoByMessage(message));
				response.setContainError(true);
				Tracer.error(log, getClass().getName(), method, "SendMessageException " + e);
			}
		}
		
		return response;
		
		
		
	}

}
