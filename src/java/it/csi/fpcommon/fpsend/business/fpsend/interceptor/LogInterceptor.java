package it.csi.fpcommon.fpsend.business.fpsend.interceptor;

import it.csi.fpcommon.fpsend.business.util.Tracer;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class LogInterceptor implements MethodInterceptor {

	public static final String LOGGER_PREFIX = "stasend.interceptor";

	private static Logger logger = Logger.getLogger(LOGGER_PREFIX);

	public Object invoke(MethodInvocation invocation) throws Throwable{
		String method = invocation.getMethod().getName();
		String className = invocation.getMethod().getDeclaringClass().getSimpleName();
		try {
			Tracer.debug(logger, className, method, "BEGIN");
			Object rval = invocation.proceed();
			return rval;
		}
		finally {
			Tracer.debug(logger, className, method, "END");
		}
	
	}

}