package com.mars.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mars.aop.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {	
		
	@Before("com.mars.aop.aspect.marsAopExpression.daoPackageNoGetterSetter()")
	public void beforeAddingAnyAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n +++AOP+++ \n====>>> Executing @Before advice on addAccount()\n +++++++++ \n");
		
		//display the method signature
		MethodSignature mySignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + mySignature);
		
		
		//display mthod arguments
		
		// get arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through arguments
		for(Object currentArg : args) {
			System.out.println(currentArg);
			if (currentArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) currentArg;
				System.out.println("Account holder name: " + theAccount.getName());
				System.out.println("Account holder level: " + theAccount.getLevel());
			}
		}
		
	}
}
