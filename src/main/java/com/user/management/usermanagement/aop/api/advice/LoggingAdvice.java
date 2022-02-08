package com.user.management.usermanagement.aop.api.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

	Logger log = org.slf4j.LoggerFactory.getLogger(LoggingAdvice.class);

	@Pointcut(value = "execution(* com.user.management.usermanagement.*.*.*(..))")
	public void pointCut() {

	}

	@Around("pointCut()")
	public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String methoName = proceedingJoinPoint.getSignature().getName();
		String className = proceedingJoinPoint.getTarget().getClass().toString();
		Object[] array = proceedingJoinPoint.getArgs();
		log.info("method invoked " + className + " : " + methoName + " arguments : " + Arrays.toString(array));
		Object result = proceedingJoinPoint.proceed();
		if (result != null) {
			log.info(className + " : " + methoName + " Response : " + result.toString());
		} else {
			
		}
		return result;
	}

}
