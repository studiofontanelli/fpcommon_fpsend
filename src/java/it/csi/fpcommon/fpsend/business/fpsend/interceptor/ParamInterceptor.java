package it.csi.fpcommon.fpsend.business.fpsend.interceptor;

import it.csi.fpcommon.fpsend.business.util.Tracer;
import it.csi.fpcommon.fpsend.business.util.XmlSerializer;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class ParamInterceptor implements MethodInterceptor {

public static final String LOGGER_PREFIX = "stasend.interceptor";
	
	private static Logger logger = Logger.getLogger(LOGGER_PREFIX);


	/*
	 * (non-Javadoc)
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String method = invocation.getMethod().getName();
		String className = invocation.getMethod().getDeclaringClass().getSimpleName();
		try {
			if(logger.isDebugEnabled()){
				Object[] temp = invocation.getArguments();
				if(temp != null){
					for (int index=0; index<temp.length; index++){
						try{
							Tracer.debug(logger, className, method, "trace param["+index+"]\n " + XmlSerializer.objectToXml(temp[index]));
						}
						catch (Exception e) {
							Tracer.warn(logger, className, method, "Error in tracing param " + temp[index]);
						}
					}
				}
			}
			Object rval = invocation.proceed();
			return rval;
		} finally {

		}
	}

}