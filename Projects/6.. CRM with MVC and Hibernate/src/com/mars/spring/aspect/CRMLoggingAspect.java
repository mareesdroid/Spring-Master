package com.mars.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CRMLoggingAspect {
	
	
	// setup Logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declaration
	@Pointcut("execution(* com.mars.spring.controller.*.*(..))")					//controller
	private void forControllerPackage() {};
	
	@Pointcut("execution(* com.mars.spring.dao.*.*(..))")							//dao
	private void forDaoPackage() {};
	
	@Pointcut("execution(* com.mars.spring.service.*.*(..))")						//service
	private void forServicePackage() {};
	
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void forAppFlow() {};
	
	
	
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoin) {
		
		// display the method we are calling
		String methodName = theJoin.getSignature().toShortString();
		myLogger.info("\n ======>> @Before Method Name" + methodName);
		// display the arguments to the method
		
		
		//loop through display args
		Object[] args  = theJoin.getArgs();
		for(Object currentArg : args) {
			myLogger.info("\n======>> Argument: " + currentArg);
		}
	}
	
	
	// add @AfterReturning advice
	@AfterReturning(pointcut="forAppFlow()",
					returning="result")
	public void after(JoinPoint theJoin, Object result) {
		// display the method we are calling
				String methodName = theJoin.getSignature().toShortString();
				myLogger.info("\n ======>> @AfterReturning Method Name" + methodName);
				
		//display data returned
				myLogger.info("\n=======>> Resilt: " + result);
	}
	
	
}
