package test.stasend;

import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UnrecoverableException;

import it.csi.stacore.stasend.dto.stasend.*;

import it.csi.stacore.stasend.interfacecsi.stasend.*;

import it.csi.stacore.stasend.exception.stasend.*;

import it.csi.csi.util.xml.*;
import it.csi.csi.porte.*;
import it.csi.csi.porte.proxy.*;
import javax.sql.DataSource;
import org.apache.log4j.*;
import junit.framework.TestCase;

/*PROTECTED REGION ID(R-956953499) ENABLED START*/
/// inserire qui eventuali import aggiuntive

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import it.csi.csi.util.DatiMessaggio;
import org.springframework.util.Log4jConfigurer;
import it.csi.stacore.stasend.business.util.Tracer;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

/*PROTECTED REGION END*/

/**
 * @generated
 */
public class TestStasend extends TestCase {

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
		InfoPortaDelegata info = PDConfigReader
				.read("test/java/test/stasend/defpd_stasend.xml");
		pd = (it.csi.stacore.stasend.interfacecsi.stasend.StasendSrv) PDProxy
				.newInstance(info);
	}

	/*PROTECTED REGION ID(R-1391459773) ENABLED START*/
	// inserire qui la definizione di variabili locali, costanti da usare nel test.
	// non verranno sovrascritte da successive rigenerazioni

	protected static Logger log = Logger.getLogger(LOGGER_PREFIX);

	public static final String CHANNEL_EMAIL = "EMAIL";
	public static final String CHANNEL_SMS = "SMS";

	public static final String CHANNEL_MOCK_EMAIL = "MOCK_EMAIL";
	public static final String CHANNEL_MOCK_SMS = "MOCK_SMS";

	public static final String TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_MAIL = "RSCA_MAIL_CNF";
	public static final String TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_SMS = "RSCA_SMS_CNF";

	public void initLog4J() throws Exception {
		Log4jConfigurer
				.initLogging("classpath:test/stasend/helper/log4j.properties");
	}

	public static Message createMailMessage() {

		Message message = new Message();
		int random = RandomUtils.nextInt();

		message.setCallerInternalCode(random + "");
		message.setSender("andrea.fontanelli@consulenti.csi.it");
		//message.setRecipient("marco.boz@csi.it");
		message.setRecipient("andrea.caligaris@csi.it");
		message.setBody("JUNIT TEST CASE=> " + random);
		message.setSubject("PROVA STASEND");
		message.setChannel(CHANNEL_EMAIL);

		return message;
	}

	public static Message createMailTemplateMessage(String template,
			String channel) {
		String method = "createMailTemplateMessage";
		Tracer.debug(log, TestStasend.class.getClass().getName(), method,
				"BEGIN");
		Message message = new Message();
		int random = RandomUtils.nextInt();

		message.setCallerInternalCode(random + "");
		message.setSender("andrea.fontanelli@consulenti.csi.it");

		message.setRecipient("studiofontanelli@gmail.com");
		message.setSubject("Conferma iscrizione al servizio di avviso di scadenza");
		message.setChannel(channel);

		message.setTemplate(new Template());
		message.getTemplate().setCode(template);

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

		PlaceHolder[] array = phList.toArray(new PlaceHolder[phList.size()]);

		message.getTemplate().setPlaceHolders(array);

		Tracer.debug(log, TestStasend.class.getClass().getName(), method, "END");
		return message;
	}

	public static Message createSmsMessage() {

		Message message = new Message();
		int random = RandomUtils.nextInt();

		message.setCallerInternalCode(random + "");
		message.setSender("Bollo facile");
		message.setRecipient("00393409323302");
		message.setBody("JUNIT SMS TEST CASE  " + random);
		message.setChannel(CHANNEL_SMS);

		return message;
	}

	public static Message createSmsTemplateMessage(String codiceTemplate,
			String channel) {

		Message message = new Message();
		int random = RandomUtils.nextInt();

		message.setCallerInternalCode(random + "");
		message.setSender("Bollo facile");
		message.setRecipient("00393409323302");

		message.setTemplate(new Template());
		message.getTemplate().setCode(codiceTemplate);

		PlaceHolder ph = new PlaceHolder();
		ph.setKey("CODICE_ATTIVAZIONE");
		ph.setValue(RandomStringUtils.random(5));

		List<PlaceHolder> phList = new ArrayList<PlaceHolder>();

		phList.add(ph);

		PlaceHolder[] array = phList.toArray(new PlaceHolder[phList.size()]);
		message.getTemplate().setPlaceHolders(array);

		message.setChannel(channel);

		return message;
	}

	public static Message createSmsTemplateMessage(String codiceTemplate) {

		Message message = new Message();
		int random = RandomUtils.nextInt();

		message.setCallerInternalCode(random + "");
		message.setSender("Bollo facile");
		message.setRecipient("00393409323302");

		message.setTemplate(new Template());
		message.getTemplate().setCode(codiceTemplate);

		PlaceHolder ph = new PlaceHolder();
		ph.setKey("CODICE_ATTIVAZIONE");
		ph.setValue(RandomStringUtils.random(5));

		List<PlaceHolder> phList = new ArrayList<PlaceHolder>();

		phList.add(ph);

		PlaceHolder[] array = phList.toArray(new PlaceHolder[phList.size()]);
		message.getTemplate().setPlaceHolders(array);

		message.setChannel(CHANNEL_SMS);

		return message;
	}

	public static RequestMessages createRequestSMSMessages() throws Exception {
		String method = "createRequestSMSMessages";
		Tracer.debug(log, TestStasend.class.getClass().getName(), method,
				"BEGIN");
		RequestMessages request = new RequestMessages();

		request.setCaller("JUNIT");

		List<Message> messages = new ArrayList<Message>();
		for (int i = 0; i < 10; i++) {
			Message message = createSmsMessage();
			messages.add(message);
			Tracer.debug(log, TestStasend.class.getClass().getName(), method,
					"message pk= " + message.getPk());
		}

		request.setMessages(messages.toArray(new Message[messages.size()]));

		Tracer.debug(log, TestStasend.class.getClass().getName(), method, "END");
		return request;

	}

	public static RequestMessages createRequestMessages() throws Exception {
		String method = "createRequestMessages";
		Tracer.debug(log, TestStasend.class.getClass().getName(), method,
				"BEGIN");
		RequestMessages request = new RequestMessages();

		request.setCaller("JUNIT");

		List<Message> messages = new ArrayList<Message>();
		for (int i = 0; i < 5; i++) {

			Message message = createMailMessage();
			messages.add(message);
			Tracer.debug(log, TestStasend.class.getClass().getName(), method,
					"message pk= " + message.getPk());
		}

		request.setMessages(messages.toArray(new Message[messages.size()]));

		Tracer.debug(log, TestStasend.class.getClass().getName(), method, "END");
		return request;

	}

	public static RequestMessage createRequestMessage() throws Exception {
		String method = "createRequestMessage";
		Tracer.debug(log, TestStasend.class.getClass().getName(), method,
				"BEGIN");
		RequestMessage request = new RequestMessage();

		request.setCaller("JUNIT");

		request.setMessage(createMailMessage());

		Tracer.debug(log, TestStasend.class.getClass().getName(), method, "END");
		return request;

	}

	public static RequestMessage createRequestMailMessage() throws Exception {
		String method = "createRequestMailMessage";
		Tracer.debug(log, TestStasend.class.getClass().getName(), method,
				"BEGIN");
		RequestMessage request = new RequestMessage();

		request.setCaller("JUNIT");

		request.setMessage(createMailMessage());

		Tracer.debug(log, TestStasend.class.getClass().getName(), method, "END");
		return request;

	}

	public static RequestMessage createRequestMailTemplateMessage(
			String template, String channel) throws Exception {
		String method = "createRequestMailTemplateMessage";
		Tracer.debug(log, TestStasend.class.getClass().getName(), method,
				"BEGIN");
		RequestMessage request = new RequestMessage();

		request.setCaller("JUNIT");

		request.setMessage(createMailTemplateMessage(template, channel));

		Tracer.debug(log, TestStasend.class.getClass().getName(), method, "END");
		return request;

	}

	public static RequestMessage createRequestSmsMessage() throws Exception {
		String method = "createRequestSmsMessage";
		Tracer.debug(log, TestStasend.class.getClass().getName(), method,
				"BEGIN");
		RequestMessage request = new RequestMessage();
		request.setCaller("JUNIT");
		request.setMessage(createSmsMessage());
		Tracer.debug(log, TestStasend.class.getClass().getName(), method, "END");
		return request;

	}

	public static RequestMessage createRequestSmsTemplateMessage()
			throws Exception {
		String method = "createRequestSmsTemplateMessage";
		Tracer.debug(log, TestStasend.class.getClass().getName(), method,
				"BEGIN");
		RequestMessage request = new RequestMessage();
		request.setCaller("JUNIT");
		request.setMessage(createSmsTemplateMessage("RSCA_SMS"));
		Tracer.debug(log, TestStasend.class.getClass().getName(), method, "END");
		return request;

	}

	/*PROTECTED REGION END*/

	/// Implementazione operazioni esposte dal servizio

	/**
	 * @generated
	 */
	public void testOperationSendMessage() {
		/*PROTECTED REGION ID(R-1720830949) ENABLED START*/
		/// inserire qui la logica di test per l'operazione.
		/// il codice sara' preservato per successive rigenerazioni

		String method = "testOperationSendMessage";
		Tracer.debug(log, getClass().getName(), method, "BEGIN");

		/// inserire qui la logica di test per l'operazione.
		/// il codice sara' preservato per successive rigenerazioni

		DatiMessaggio datiMsg = new DatiMessaggio();

		try {

			initLog4J();
			RequestMessage request = createRequestMailTemplateMessage(
					TEMPLATE_REGISTRAZIONE_RICORDA_SCADENZA_MAIL, CHANNEL_EMAIL);
			String s = pd.sendMessage(request, datiMsg);
			Tracer.debug(log, getClass().getName(), method, "return " + s);

		} catch (Exception e) {
			Tracer.error(log, getClass().getName(), method, "Exception " + e);
		} finally {
			Tracer.debug(log, getClass().getName(), method, "END");
		}

		/*PROTECTED REGION END*/
	}

	/**
	 * @generated
	 */
	public void testOperationSendMessages() {
		/*PROTECTED REGION ID(R-1806151752) ENABLED START*/

		String method = "testOperationSendMessages";
		Tracer.debug(log, getClass().getName(), method, "BEGIN");

		/// inserire qui la logica di test per l'operazione.
		/// il codice sara' preservato per successive rigenerazioni

		DatiMessaggio datiMsg = new DatiMessaggio();

		try {

			initLog4J();
			RequestMessages request = createRequestMessages();
			String s = pd.sendMessages(request, datiMsg);
			Tracer.debug(log, getClass().getName(), method, "return " + s);

		} catch (Exception e) {
			Tracer.error(log, getClass().getName(), method, "Exception " + e);
		} finally {
			Tracer.debug(log, getClass().getName(), method, "END");
		}

		/*PROTECTED REGION END*/
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

	/// eventuali metodi aggiuntivi
	/*PROTECTED REGION ID(R-1478336464) ENABLED START*/
	// inserire qui la dichiarazione di eventuali metodi aggiuntivi utili
	// per l'implementazione.
	// non verra' sovrascritto da successive rigenerazioni.

	/*PROTECTED REGION END*/
}
