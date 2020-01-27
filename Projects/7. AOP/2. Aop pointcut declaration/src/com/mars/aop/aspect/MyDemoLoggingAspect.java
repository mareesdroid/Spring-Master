package com.mars.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
														///pointcut declaraion
	@Pointcut("execution(** com.mars.aop.dao.*.*(..))")
	private void forDAOPackage() {
		
	}
		
	@Before("forDAOPackage()")
	public void beforeAddingAnyAdvice() {
		System.out.println("\n +++AOP+++ \n====>>> Executing @Before advice on addAccount()\n +++++++++ \n");
	}
	
	@Before("forDAOPackage()")
	public void performApiAnalysis() {
		System.out.println("\n +++AOP+++ \n====>>> Performing API Analysis\n +++++++++ \n");
	}
}
