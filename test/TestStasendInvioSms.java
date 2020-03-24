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
import it.csi.stacore.stasend.dto.stasend.Template;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Log4jConfigurer;





/**
 * @generated
 */
public class TestStasendInvioSms extends TestCase {

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

	private static final String CHANNEL_EMAIL = "EMAIL";
	private static final String CHANNEL_SMS = "SMS";

	private static final String CHANNEL_MOCK_EMAIL = "MOCK_EMAIL";
	private static final String CHANNEL_MOCK_SMS = "MOCK_SMS";

	private void initLog4J() throws Exception {
		Log4jConfigurer.initLogging("classpath:test/stasend/helper/log4j.properties");
	}

	
	
	
	


	
	public void testOperationInvioSms() {
		

		String method = "testOperationInvioSms";
		Tracer.debug(log, getClass().getName(), method, "BEGIN");

		

		DatiMessaggio datiMsg = new DatiMessaggio();

		try {

			initLog4J();
			// RICHIESTA
			
			RequestMessage request = new RequestMessage();

			request.setCaller("JUNIT"); // DA CONCORDARE
		
			Message message = new Message();
			message.setCallerInternalCode(RandomUtils.nextInt()+"");
			message.setSender("Bollo facile");
			message.setRecipient("3409323302");
			
			String body = "Gentile utente, ti sei registrato con successo al servizio Ricorda scadenza.";
			message.setBody(body);
			
			message.setChannel(CHANNEL_SMS); 
			
			
			request.setMessage(message);
			
			
			String s = pd.sendMessage(request, datiMsg);
			
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
