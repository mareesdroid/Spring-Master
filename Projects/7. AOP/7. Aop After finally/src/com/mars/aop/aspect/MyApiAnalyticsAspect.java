package com.mars.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class MyApiAnalyticsAspect {
	@Before("com.mars.aop.aspect.marsAopExpression.daoPackageNoGetterSetter()")
	public void performApiAnalysis() {
		System.out.println("\n +++AOP+++ \n====>>> Performing API Analysis\n +++++++++ \n");
	}
}
