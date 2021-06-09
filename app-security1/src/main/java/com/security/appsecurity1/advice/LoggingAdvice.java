package com.security.appsecurity1.advice;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAdvice {

	private static final Logger LOGGER = LogManager.getLogger(LoggingAdvice.class);

	// AOP expression for which methods shall be intercepted
	@Around("execution(* com.security.appsecurity1..*(..)))")
	public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

		// Get intercepted method details
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();
		
		String[] arguments = methodSignature.getParameterNames();
        
        
		LOGGER.info("Arguments of :: " + className + "." + methodName + " :: "  + Arrays.deepToString(arguments));
		final StopWatch stopWatch = new StopWatch();

		// Measure method execution time
		stopWatch.start();
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();

		// Log method execution time
		LOGGER.info(
				"Execution time of " + className + "." + methodName + " :: " + stopWatch.getTotalTimeMillis() + " ms");

		return result;
	}
}
