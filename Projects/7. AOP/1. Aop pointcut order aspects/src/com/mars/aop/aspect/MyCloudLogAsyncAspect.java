package com.mars.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyCloudLogAsyncAspect {
	@Before("com.mars.aop.aspect.marsAopExpression.daoPackageNoGetterSetter()")
	public void performCloudAnalysis() {
		System.out.println("\n +++AOP+++ \n====>>> Performing Cloud Analysis\n +++++++++ \n");
	}
}
