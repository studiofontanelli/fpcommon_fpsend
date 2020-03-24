package test.stasend;

import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.DatiMessaggio;
import it.csi.csi.util.xml.PDConfigReader;
import it.csi.stacore.stasend.business.util.Tracer;
import it.csi.stacore.stasend.dto.stasend.RequestMessage;

import org.springframework.util.Log4jConfigurer;



/**
 * @generated
 */
public class TestStasendSoap  extends TestStasend {

	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "stasend.soap";

	/**
	 * @generated
	 */
	it.csi.stacore.stasend.interfacecsi.stasend.StasendSrv pd = null;

	/**
	 * @generated
	 */
	public void setUp() throws Exception {
		
		InfoPortaDelegata info = PDConfigReader.read("test/java/test/stasend/defpd_stasendsoap.xml");
		pd = (it.csi.stacore.stasend.interfacecsi.stasend.StasendSrv) PDProxy.newInstance(info);
		System.out.println("setUp::pd loaded correctly!");
	}
	
	
	public void testOperationSendMessage() {
		

		String method = "testOperationSendMessage";
		DatiMessaggio datiMsg = new DatiMessaggio();
		try {

			initLog4J();
			Tracer.debug(log, getClass().getName(), method, "BEGIN");
			
			
			RequestMessage request = createRequestMailTemplateMessage(TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_MAIL, CHANNEL_EMAIL);
			String s = pd.sendMessage(request, datiMsg);
			Tracer.debug(log, getClass().getName(), method, "return " + s);

		} catch (Exception e) {
			Tracer.error(log, getClass().getName(), method, "Exception " + e);
		} finally {
			Tracer.debug(log, getClass().getName(), method, "END");
		}
	}
	
}
