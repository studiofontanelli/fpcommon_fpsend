package it.csi.fpcommon.fpsend.business.fpsend.spring.startup;

import it.csi.fpcommon.fpsend.business.util.Tracer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.context.access.ContextBeanFactoryReference;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @generated
 */
public class JunitLoadStartupService implements LoadStartupServiceMBean {


	public static final String LOGGER_PREFIX = "stasend";
	public static Logger log = Logger.getLogger(LOGGER_PREFIX);

	/** Spring BeanFactory that provides the namespace for this EJB 
	 * @generated
	 */
	private static BeanFactoryReference beanFactoryReference;

	/**
	 * @generated
	 */
	private String message = "problems....";

	/**
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @generated
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @generated
	 */
	public void printMessage() {
		System.out.println(message);
	}

	/**
	 * @generated
	 */
	public void start() throws Exception {

		System.out.println("Messaggio di avvio MBEAN=" + message);
		try {
			ClassPathXmlApplicationContext ctx =  new ClassPathXmlApplicationContext(new String[] { "classpath:/test/stasend/helper/applicationTestContext.xml" });
			beanFactoryReference = new ContextBeanFactoryReference(ctx);


		} catch (Exception e) {
			System.out.println("Attenzione si e' verificata un'eccezione: " + e);
		}

		System.out.println("Chiamata da MBEAN eseguita!!!!");


	}

	/**
	 * @generated
	 */
	public static Object getBean(String beanName) {

		String method = "getBean";
		if(log.isDebugEnabled()){
			Tracer.debug(log, JunitLoadStartupService.class.getName(), method, "BEGIN");
		}


		Object beanObject = null;

		try {

			beanObject = beanFactoryReference.getFactory().getBean(beanName);

		} catch (Exception e) {
			System.out.println("Attenzione si � verificata un'eccezione: " + e);
		}
		if(log.isDebugEnabled()){
			Tracer.debug(log, JunitLoadStartupService.class.getName(), method, "END");
		}
		return beanObject;
	}

	/**
	 * @generated
	 */
	public void stop() {
		System.out.println("Messaggio di stop MBEAN=" + message);
	}
}
