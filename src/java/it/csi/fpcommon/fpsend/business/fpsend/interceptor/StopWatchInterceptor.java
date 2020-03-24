package it.csi.fpcommon.fpsend.business.fpsend.interceptor;

import it.csi.util.performance.StopWatch;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class StopWatchInterceptor implements MethodInterceptor {

	public static final String LOGGER_PREFIX = "stasend";

	StopWatch stopWatch = null; 

	public Object invoke(MethodInvocation invocation) throws Throwable {
		String method = invocation.getMethod().getName();
		String className = invocation.getMethod().getDeclaringClass().getSimpleName();
		try {
			stopWatch = new StopWatch(LOGGER_PREFIX);
			stopWatch.start();
			Object rval = invocation.proceed();
			return rval;
		}
		finally {
			
			stopWatch.stop();
			stopWatch.dumpElapsed(className, method, "invocazione servizio " + method, "(valore input omesso)");
			
		}
	}

}