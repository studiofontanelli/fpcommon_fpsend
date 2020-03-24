 package test.fpsend;

import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.DatiMessaggio;
import it.csi.csi.util.xml.PDConfigReader;
import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.dto.fpsend.Message;
import it.csi.fpcommon.fpsend.dto.fpsend.PlaceHolder;
import it.csi.fpcommon.fpsend.dto.fpsend.RequestMessages;
import it.csi.fpcommon.fpsend.dto.fpsend.Template;
import it.csi.fpcommon.fpsend.interfacecsi.fpsend.FpsendSrv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Log4jConfigurer;





/**
 * @generated
 */
public class TestStasendInvioEmailDiRettifica extends TestCase {

	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "fpsend";

	/**
	 * @generated
	 */
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

	
	
	private void readFile() throws Exception {
		File file = new File("/opt/java/csi/mmd/workspace/stacore_fpsend/test/java/test/fpsend/data/data.txt");
		
		BufferedReader br = new BufferedReader(new FileReader("/opt/java/csi/mmd/workspace/stacore_fpsend/test/java/test/fpsend/data/data.txt"));
		
		
	}
	


	
	public void testOperationInvioDiRettifica() {
		

		String method = "testOperationInvioDiRettifica";
		Tracer.debug(log, getClass().getName(), method, "BEGIN");

		DatiMessaggio datiMsg = new DatiMessaggio();

		List<String> emails = new ArrayList<String>();
		try {

			initLog4J();
			
			BufferedReader br = new BufferedReader(new FileReader("/opt/java/csi/mdd/workspace/stacore_fpsend/test/java/test/fpsend/data/data.txt"));
			String line;
			boolean first = true;
			
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				
				if(first){
					first = false;
					continue;
				}
				String [] record = StringUtils.split(line, ";");
				//System.out.println(record.length);
				emails.add( record[0]);
			} 
			br.close();
			
			
			Tracer.debug(log, getClass().getName(), method, "file ok");
			
			Tracer.debug(log, getClass().getName(), method, "carcati " +  emails.size() + " indirizzi email");
			
			
			
			
			RequestMessages request = new RequestMessages();
			request.setCaller("SERVIZIO"); 
			
			List<Message> messages = new ArrayList<Message>();
			
			
			
			
			
			for(String email : emails){
				Message message = new Message();
				
				message.setSender("memobollo_noreply@csi.it");
				message.setRecipient(email);
				
				message.setSubject("ERRATO INVIO - Ricorda Scadenza");
				message.setChannel(CHANNEL_EMAIL); 
				
				message.setTemplate(new Template());
				message.getTemplate().setCode("SERV_MAIL_ERRATA");
				messages.add(message);
				
				List<PlaceHolder> phList = new ArrayList<PlaceHolder>();
				PlaceHolder[] array = phList.toArray(new PlaceHolder[phList.size()]);

				message.getTemplate().setPlaceHolders(array);
				
			}
			
			Message [] array = messages.toArray(new Message[messages.size()]);
			
			
			request.setMessages(array);
			
			String s = pd.sendMessages(request, datiMsg);
			
			

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
