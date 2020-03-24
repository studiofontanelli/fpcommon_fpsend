package test.stasend;

import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.DatiMessaggio;
import it.csi.csi.util.xml.PDConfigReader;
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
public class TestStasendInvioEmailTemplate extends TestCase {

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
			message.setSender("andrea.fontanelli@csi.it");
			message.setRecipient("studiofontanelli@gmail.com");

			message.setSubject("Conferma iscrizione al servizio di avviso di scadenza");
			message.setChannel(CHANNEL_EMAIL); 

			message.setTemplate(new Template());
			message.getTemplate().setCode("TEST_MAIL");


			List<PlaceHolder> phList = new ArrayList<PlaceHolder>();


			PlaceHolder ph = new PlaceHolder();

			ph.setKey("COGNOME");
			ph.setValue("Fontanelli");
			phList.add(ph);


			ph = new PlaceHolder();
			ph.setKey("NOME");
			ph.setValue("Andrea");
			phList.add(ph);

			ph = new PlaceHolder();
			ph.setKey("CODICE_FISCALE");
			ph.setValue("FNTNDR73B22L219M");
			phList.add(ph);


			ph = new PlaceHolder();
			ph.setKey("VEICOLO");
			ph.setValue("autovettura targata RTTRTRT\n motoveicolo targato BDHDHDD\n Trattore targato HDHJDJD");
			phList.add(ph);

			ph = new PlaceHolder();
			ph.setKey("URL_CONFERMA");
			ph.setValue("www.mipiacitu.it");
			phList.add(ph);


			ph = new PlaceHolder();
			ph.setKey("");
			ph.setValue("");
			phList.add(ph);


			PlaceHolder[] array = phList.toArray(new PlaceHolder[phList.size()]);

			message.getTemplate().setPlaceHolders(array);



			request.setMessage(message);

			String s = pd.sendMessage(request, datiMsg);

			Tracer.debug(log, getClass().getName(), method, "return " + s);

		} catch (Exception e) {
			Tracer.error(log, getClass().getName(), method, "Exception " + e);
		} finally {
			Tracer.debug(log, getClass().getName(), method, "END");
		}


	}



	public void testOperationInvioEmailEsenziniDisabli() {


		String method = "testOperationInvioEmailEsenziniDisabli";
		Tracer.debug(log, getClass().getName(), method, "BEGIN");



		DatiMessaggio datiMsg = new DatiMessaggio();

		try {

			initLog4J();

			RequestMessage request = new RequestMessage();
			request.setCaller("ESE"); 

			Message message = new Message();
			message.setCallerInternalCode(RandomUtils.nextInt()+"");
			message.setSender("andrea.fontanelli@csi.it");
			message.setRecipient("studiofontanelli@gmail.com");

			message.setSubject("UAUAUIUOUA");
			message.setChannel(CHANNEL_EMAIL); 

			message.setTemplate(new Template());
			message.getTemplate().setCode("ESE_FO_EMAIL");


			List<PlaceHolder> phList = new ArrayList<PlaceHolder>();


			PlaceHolder ph = new PlaceHolder();

			ph.setKey("CODICE_FISCALE");
			ph.setValue("FNTNDR73B22L219M");
			phList.add(ph);


			ph = new PlaceHolder();
			ph.setKey("TARGA");
			ph.setValue("DB658BH");
			phList.add(ph);

			ph = new PlaceHolder();
			ph.setKey("PROTOCOLLO_COMUNICAZIONE");
			ph.setValue("00112233");
			phList.add(ph);


			ph = new PlaceHolder();
			ph.setKey("STATO_COMUNICAZIONE");
			ph.setValue("Italiano");
			phList.add(ph);

			


			


			PlaceHolder[] array = phList.toArray(new PlaceHolder[phList.size()]);

			message.getTemplate().setPlaceHolders(array);



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
