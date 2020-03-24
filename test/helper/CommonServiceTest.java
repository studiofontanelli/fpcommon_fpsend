package test.stasend.helper;

import it.csi.stacore.stasend.business.stasend.spring.startup.JunitLoadStartupService;
import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class CommonServiceTest extends TestCase {
	
	
	public static final String LOGGER_PREFIX = "stasend";
	public static Logger log = Logger.getLogger(LOGGER_PREFIX);
	
	
	//private ApplicationContext ctx = null;
	
	
	/*
	public ApplicationContext getCtx() {
		return ctx;
	}
	*/
	
	public void setUp() throws Exception {
		try {

	        //System.setProperty("log4j.configuration", new File(System.getProperty("user.dir")+File.separator+"conf"+File.separator+"log4j.properties").toURI().toURL().toString());
			Log4jConfigurer.initLogging( "classpath:test/stasend/helper/log4j.properties" );
			//ctx = new ClassPathXmlApplicationContext(new String[] { "classpath:/test/stasend/helper/applicationTestContext.xml" });
			
			JunitLoadStartupService springService = new JunitLoadStartupService();
			springService.start();
			
			System.out.println("Contesto Spring inizializzato correttamente");
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	public void tearDown() throws Exception {
	}
	
	

}
