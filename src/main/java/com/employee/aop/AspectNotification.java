package com.employee.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectNotification {

	private static final Logger LOGGER = LoggerFactory.getLogger(AspectNotification.class);

	 @Before("execution(* com.employee.*.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		LOGGER.info("before logging");
		LOGGER.info(joinPoint.getSignature().getName());
	}

	@After("execution(* com.employee.*.*.*(..))")
	
	public void logAfter(JoinPoint joinPoint) {

		LOGGER.info(" after logging");
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(" Allowed execution for {}  " + joinPoint.getSignature().getName());
			LOGGER.info("args " + Arrays.toString(joinPoint.getArgs()));
		}
	}

	@AfterReturning(pointcut = "execution(* com.employee.exception.GlobalExceptionHandler.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {

		LOGGER.debug("logging after returning ");
		if (LOGGER.isDebugEnabled())
			LOGGER.debug(joinPoint.getSignature().getName() + " Returned with " + result);

	}

	@AfterThrowing("execution(* com.employee.*.*.*(..))")
	public void afterThrowing(JoinPoint joinPoint) {
		if (LOGGER.isErrorEnabled())
			LOGGER.error("exception method " + joinPoint.getSignature().getName());
	}
}
