package test.stasend;

import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.DatiMessaggio;
import it.csi.csi.util.xml.PDConfigReader;
import it.csi.stacore.stasend.business.stasend.integration.dto.richiesta.SMS;
import it.csi.stacore.stasend.business.util.Tracer;
import it.csi.stacore.stasend.dto.stasend.Message;
import it.csi.stacore.stasend.dto.stasend.PlaceHolder;
import it.csi.stacore.stasend.dto.stasend.RequestMessage;
import it.csi.stacore.stasend.dto.stasend.RequestMessages;
import it.csi.stacore.stasend.dto.stasend.Template;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.omg.CORBA.Request;
import org.springframework.util.Log4jConfigurer;





/**
 * @generated
 */
public class TestStasendInvioMassivo extends TestCase {

	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "stasend";

	/**
	 * @generated
	 */
	it.csi.stacore.stasend.interfacecsi.stasend.StasendSrv pd = null;

	/**
	 * @generated
	 */
	public void setUp() throws Exception {
		InfoPortaDelegata info = PDConfigReader.read("test/java/test/stasend/defpd_stasend.xml");
		pd = (it.csi.stacore.stasend.interfacecsi.stasend.StasendSrv) PDProxy.newInstance(info);
	}


	private static Logger log = Logger.getLogger(LOGGER_PREFIX);

	
	
	
	//RSCA_SMS_CNF
	

	private void initLog4J() throws Exception {
		Log4jConfigurer.initLogging("classpath:test/stasend/helper/log4j.properties");
	}

	
	
	
	


	
	public void testOperationInvioMassivo() {
		

		String method = "testOperationInvioMassivo";
		Tracer.debug(log, getClass().getName(), method, "BEGIN");

		

		DatiMessaggio datiMsg = new DatiMessaggio();

		try {

			initLog4J();
			// RICHIESTA
			
			RequestMessages request = new RequestMessages();

			request.setCaller("JUNIT"); // DA CONCORDARE
			
			
			List<Message> messageList = new ArrayList<Message>();
			
			
			messageList.add(TestStasend.createMailMessage());
			messageList.add(TestStasend.createMailTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_MAIL, TestStasend.CHANNEL_EMAIL));
			messageList.add(TestStasend.createMailTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_MAIL, TestStasend.CHANNEL_EMAIL));
			messageList.add(TestStasend.createMailTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_MAIL, TestStasend.CHANNEL_EMAIL));
			messageList.add(TestStasend.createMailMessage());
			
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			
				/*
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			messageList.add(TestStasend.createSmsTemplateMessage(TestStasend.TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS, TestStasend.CHANNEL_MOCK_SMS));
			*/
			
			
			
			Message [] array = messageList.toArray(new Message[messageList.size()]);
			
			
			request.setMessages(array);
			
			String s = pd.sendMessages(request, datiMsg);
			
			Tracer.debug(log, getClass().getName(), method, "return " + s);

		} catch (Exception e) {
			Tracer.error(log, getClass().getName(), method, "Exception " + e);
		} finally {
			Tracer.debug(log, getClass().getName(), method, "END");
		}

		
	}

	
	/**
	 * @generated
	 */
	protected Logger getLogger(String subsystem) {
		if (subsystem != null)
			return Logger.getLogger(LOGGER_PREFIX + "." + subsystem);
		else
			return Logger.getLogger(LOGGER_PREFIX);
	}

	
}
