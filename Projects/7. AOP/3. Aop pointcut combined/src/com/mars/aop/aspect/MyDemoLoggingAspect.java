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
	
	// create poincut for getter
	@Pointcut("execution(** com.mars.aop.dao.*.get*(..))")
	private void getter() {
		
	}
	// create poincut for setter
	@Pointcut("execution(** com.mars.aop.dao.*.set*(..))")
	private void setter() {
		
	}
	
	// create pintcut: for all dao except getter/setter methods
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	private void daoPackageNoGetterSetter() {
		
	}
		
	@Before("daoPackageNoGetterSetter()")
	public void beforeAddingAnyAdvice() {
		System.out.println("\n +++AOP+++ \n====>>> Executing @Before advice on addAccount()\n +++++++++ \n");
	}
	
	@Before("daoPackageNoGetterSetter()")
	public void performApiAnalysis() {
		System.out.println("\n +++AOP+++ \n====>>> Performing API Analysis\n +++++++++ \n");
	}
}
