package test.fpsend;

import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.DatiMessaggio;
import it.csi.csi.util.xml.PDConfigReader;
import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.dto.fpsend.RequestMessage;
import it.csi.fpcommon.fpsend.interfacecsi.fpsend.FpsendSrv;



/**
 * @generated
 */
public class TestFpsendSoap  extends TestFpsend {

	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "fpsend.soap";

	/**
	 * @generated
	 */
	FpsendSrv pd = null;

	/**
	 * @generated
	 */
	public void setUp() throws Exception {
		
		InfoPortaDelegata info = PDConfigReader.read("test/java/test/fpsend/defpd_fpsendsoap.xml");
		pd = (FpsendSrv) PDProxy.newInstance(info);
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
