package test.fpsend;

import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.DatiMessaggio;
import it.csi.csi.util.xml.PDConfigReader;
import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;
import it.csi.fpcommon.fpsend.dto.fpsend.RequestMessage;
import it.csi.fpcommon.fpsend.interfacecsi.fpsend.FpsendSrv;
import junit.framework.TestCase;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Log4jConfigurer;





/**
 * @generated
 */
public class TestFpsendInvioEmail extends TestCase {

	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "fpsend";

	FpsendSrv pd = null;

	/**
	 * @generated
	 */
	public void setUp() throws Exception {
		InfoPortaDelegata info = PDConfigReader.read("test/java/test/fpsend/defpd_fpsend.xml");
		pd = (FpsendSrv) PDProxy.newInstance(info);
	}


	private static Logger log = Logger.getLogger(LOGGER_PREFIX);

	private static final String CHANNEL_EMAIL = "EMAIL";
	private static final String CHANNEL_SMS = "SMS";

	private static final String CHANNEL_MOCK_EMAIL = "MOCK_EMAIL";
	private static final String CHANNEL_MOCK_SMS = "MOCK_SMS";

	private void initLog4J() throws Exception {
		Log4jConfigurer.initLogging("classpath:test/fpsend/helper/log4j.properties");
	}

	
	
	
	


	
	public void testOperationInvioEmail() {
		

		String method = "testOperationInvioEmail";
		Tracer.debug(log, getClass().getName(), method, "BEGIN");

		

		DatiMessaggio datiMsg = new DatiMessaggio();

		try {

			initLog4J();
			
			
			RequestMessage request = new RequestMessage();
			request.setCaller("JUNIT"); 
			
			Message message = new Message();
			message.setCallerInternalCode(RandomUtils.nextInt()+"");
			message.setSender("memobollo_noreply@csi.it");
			message.setRecipient("andrea.fontanelli@csi.it");
			message.setBody("Ma che bella giornata");
			message.setSubject("STASEND");
			message.setChannel(CHANNEL_EMAIL); 
			
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
