package com.mars.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {	
		
	@Before("com.mars.aop.aspect.marsAopExpression.daoPackageNoGetterSetter()")
	public void beforeAddingAnyAdvice() {
		System.out.println("\n +++AOP+++ \n====>>> Executing @Before advice on addAccount()\n +++++++++ \n");
	}
}
