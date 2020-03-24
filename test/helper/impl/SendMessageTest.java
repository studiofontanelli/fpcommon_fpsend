package test.stasend.helper.impl;

import it.csi.stacore.stasend.business.stasend.helper.MessageSenderHelper;
import it.csi.stacore.stasend.business.stasend.spring.JunitSpringBeanLocator;
import it.csi.stacore.stasend.business.util.Tracer;
import it.csi.stacore.stasend.dto.stasend.Message;
import it.csi.stacore.stasend.dto.stasend.RequestMessage;
import it.csi.stacore.stasend.dto.stasend.RequestMessages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

import test.stasend.TestStasend;
import test.stasend.helper.CommonServiceTest;



public class SendMessageTest extends CommonServiceTest{

	

	private Message createMessage(int id){

		Message message = new Message();
		message.setCallerInternalCode(id+"");
		message.setSender("ME MEDESIMO");
		message.setRecipient("DESTINATARIO_"+id);
		message.setBody("BODY MESSAGE_" + id);
		message.setSubject("OGGETTO_"+id);
		message.setChannel(TestStasend.CHANNEL_EMAIL);

		return message;
	}
	
	
	
	
	


	public void testSendMessage() throws Exception {
		String method = "testSendMessage";
		Tracer.debug(log,  getClass().getName(), method, "BEGIN");

		try {	

			String codiceCodaJMS = RandomStringUtils.randomAlphanumeric(50);
			//String codiceCodaJMS = "aBVysoh4JpelMTHQUeIFhTBgI8sg3vytNWxgdDi6ey5OJjc7gR";

			RequestMessage request = TestStasend.createRequestMessage();
			MessageSenderHelper helper = (MessageSenderHelper) JunitSpringBeanLocator.getBean("messageSenderHelper");
			helper.sendMessage(request, codiceCodaJMS);
			
		} catch (Exception e) {
			Tracer.error(log,  getClass().getName(), method, "Exception=> " + e);
		}	
		finally{
			Tracer.debug(log,  getClass().getName(), method, "END");
		}
	}
	
	
	
	
	public void testSendEmailMessage() throws Exception {
		String method = "testSendEmailMessage";
		Tracer.debug(log,  getClass().getName(), method, "BEGIN");

		try {	

			String codiceCodaJMS = RandomStringUtils.randomAlphanumeric(50);
			//String codiceCodaJMS = "aBVysoh4JpelMTHQUeIFhTBgI8sg3vytNWxgdDi6ey5OJjc7gR";

			RequestMessage request = TestStasend.createRequestMailMessage();
			MessageSenderHelper helper = (MessageSenderHelper) JunitSpringBeanLocator.getBean("messageSenderHelper");
			helper.sendMessage(request, codiceCodaJMS);
			
		} catch (Exception e) {
			Tracer.error(log,  getClass().getName(), method, "Exception=> " + e);
		}	
		finally{
			Tracer.debug(log,  getClass().getName(), method, "END");
		}
	}
	
	public void testSendEmailTemplateMessage() throws Exception {
		String method = "testSendEmailTemplateMessage";
		Tracer.debug(log,  getClass().getName(), method, "BEGIN");

		try {	

			String codiceCodaJMS = RandomStringUtils.randomAlphanumeric(50);
			//String codiceCodaJMS = "aBVysoh4JpelMTHQUeIFhTBgI8sg3vytNWxgdDi6ey5OJjc7gR";

			//RequestMessage request = TestStasend.createRequestMailTemplateMessage(CHANNEL_EMAIL);
			RequestMessage request = TestStasend.createRequestMailTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_EMAIL);
			
			MessageSenderHelper helper = (MessageSenderHelper) JunitSpringBeanLocator.getBean("messageSenderHelper");
			Tracer.debug(log,  getClass().getName(), method, "calling helper");
			
			helper.sendMessage(request, codiceCodaJMS);
			
		} catch (Exception e) {
			Tracer.error(log,  getClass().getName(), method, "Exception=> " + e);
		}	
		finally{
			Tracer.debug(log,  getClass().getName(), method, "END");
		}
	}
	
	
	public void testSendSmsMessage() throws Exception {
		String method = "testSentestSendSmsMessagedEmailMessage";
		Tracer.debug(log,  getClass().getName(), method, "BEGIN");

		try {	

			String codiceCodaJMS = RandomStringUtils.randomAlphanumeric(50);
			//String codiceCodaJMS = "aBVysoh4JpelMTHQUeIFhTBgI8sg3vytNWxgdDi6ey5OJjc7gR";

			RequestMessage request = TestStasend.createRequestSmsMessage();
			MessageSenderHelper helper = (MessageSenderHelper) JunitSpringBeanLocator.getBean("messageSenderHelper");
			helper.sendMessage(request, codiceCodaJMS);
			
		} catch (Exception e) {
			Tracer.error(log,  getClass().getName(), method, "Exception=> " + e);
		}	
		finally{
			Tracer.debug(log,  getClass().getName(), method, "END");
		}
	}
	
	public void testSendSmsTemplateMessage() throws Exception {
		String method = "testSendSmsTemplateMessage";
		Tracer.debug(log,  getClass().getName(), method, "BEGIN");

		try {	

			String codiceCodaJMS = RandomStringUtils.randomAlphanumeric(50);
			//String codiceCodaJMS = "aBVysoh4JpelMTHQUeIFhTBgI8sg3vytNWxgdDi6ey5OJjc7gR";

			RequestMessage request = TestStasend.createRequestSmsTemplateMessage();
			MessageSenderHelper helper = (MessageSenderHelper) JunitSpringBeanLocator.getBean("messageSenderHelper");
			helper.sendMessage(request, codiceCodaJMS);
			
		} catch (Exception e) {
			Tracer.error(log,  getClass().getName(), method, "Exception=> " + e);
		}	
		finally{
			Tracer.debug(log,  getClass().getName(), method, "END");
		}
	}
	
	
	public void testSendMessages() throws Exception {
		String method = "testSendMessages";
		Tracer.debug(log,  getClass().getName(), method, "BEGIN");

		try {	

			String codiceCodaJMS = RandomStringUtils.randomAlphanumeric(50);
			//String codiceCodaJMS = "aWUpZdPjqWAeEusyUHA8vvkoGDLXUWh7goimNJHwwtDej9yNwe";
			

			RequestMessages request =  TestStasend.createRequestSMSMessages();

			
			MessageSenderHelper helper = (MessageSenderHelper) JunitSpringBeanLocator.getBean("messageSenderHelper");
			helper.sendMessages(request, codiceCodaJMS);
			
		} catch (Exception e) {
			Tracer.error(log,  getClass().getName(), method, "Exception=> " + e);
		}	
		finally{
			Tracer.debug(log,  getClass().getName(), method, "END");
		}
	}

}
