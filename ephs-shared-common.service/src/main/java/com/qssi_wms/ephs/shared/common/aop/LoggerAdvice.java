package com.qssi_wms.ephs.shared.common.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAdvice {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Around("@annotation(Loggable)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		log.info("Start :: {}", joinPoint.getSignature());
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - start;
		log.info("End :: {} and executed in {} ms", joinPoint.getSignature(), executionTime);

		return proceed;
	}

}
