package it.csi.fpcommon.fpsend.business.fpsend.integration.impl;

import it.csi.fpcommon.fpsend.business.fpsend.integration.MessageProvider;
import it.csi.fpcommon.fpsend.business.fpsend.integration.dto.ProviderResponse;
import it.csi.fpcommon.fpsend.business.util.MimeType;
import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.business.util.XmlSerializer;
import it.csi.fpcommon.fpsend.dto.fpsend.Attachment;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;
import it.csi.fpcommon.fpsend.exception.fpsend.SendMessageException;
import it.legalmail.client.address.impl.MailboxImpl;
import it.legalmail.client.message.Attachments;
import it.legalmail.client.message.Composer;
import it.legalmail.client.message.Composers;
import it.legalmail.client.message.MessageID;
import it.legalmail.client.message.Text.Type;
import it.legalmail.client.message.Texts;
import it.legalmail.client.server.Connection;
import it.legalmail.client.server.Server;
import it.legalmail.client.server.Servers;
import it.legalmail.client.smtp.Transport;
import it.legalmail.client.smtp.Transports;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class PecMessageProviderImpl extends EmailMessageProviderImpl implements MessageProvider{

	public static final String LOGGER_PREFIX = "stasend.integration";
	private static Logger log = Logger.getLogger(LOGGER_PREFIX);

	private String smtp = null;
	private String userId = null;
	private String password = null;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSmtp() {
		return smtp;
	}
	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	


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
		
		Transport transport = null;
		
		try{
	
			Composer composer  = Composers.newComposer();
			
			composer.setFrom(MailboxImpl.newInstance(new InternetAddress(message.getSender())));
			composer.addTo(MailboxImpl.newInstance(new InternetAddress(message.getRecipient())));
			
			if(message.getAttachment() != null){
				Attachment msgAtt = message.getAttachment();
				InputStream is = new ByteArrayInputStream(msgAtt.getAttachment());
				String mimeType = MimeType.PDF;

				it.legalmail.client.message.Attachment attachment = Attachments.newAttachment(is, msgAtt.getName(), mimeType);
				composer.addAttachment(attachment);
			}
			composer.setSubject(message.getSubject());
			composer.setText(Texts.newText(Type.PLAIN, message.getBody()));
			
			Tracer.info(log, getClass().getName(), method, "composer= " + XmlSerializer.objectToXml(composer));
			
			
			Server server = Servers.newServer(getSmtp(), Connection.SSL);
			
			transport = Transports.newTransport(server, userId, password);
			
			transport.connect();
	        MessageID messageId =  transport.send(composer);
	        
	        MimeMessage  mm = null;
	        
	        
	        
	        Tracer.info(log, getClass().getName(), method, "messageId value= " + messageId.getValue());
	        Tracer.info(log, getClass().getName(), method, "messageId value WithoutBrackets= " + messageId.getValueWithoutBrackets());

			response.setResult(messageId.getValueWithoutBrackets());
			Tracer.info(log, getClass().getName(), method, "pec  " + response.getResult() + " inviata correttamente!");
		}
		catch(Exception e){
			Tracer.error(log, getClass().getName(), method, "Exception  = " + e);
			throw new SendMessageException(e.getMessage());
		}
		catch(Throwable e){
			Tracer.error(log, getClass().getName(), method, "Throwable  = " + e);
			throw new SendMessageException(e.getMessage());
		}
		finally{
			 try {
				transport.close();
			} catch (MessagingException e) {
				Tracer.error(log, getClass().getName(), method, "MessagingException: " + e);
			}
		}
		return response;
	}

	

}
