package com.mars.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.mars.aop.service.*.getFortune(..))")
	public Object aroundGetTraffic(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		// print out which method we are advicing on 
		String methodName = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("------>>>>>.AOP DEBUGGING LOGS BEGIN:");
		
		myLogger.info("@Around : Method name : " + methodName);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, let's execute the method
		// join point like a handler it executes the method(com.mars.aop.service.*.getFortune.getfortune()) proceed will execute the method
		// result will get the method returns
		Object result = null;
		try {
		result = theProceedingJoinPoint.proceed();
		} catch(Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			// give user a custom message 
			
			// result = "Major Accident highway closed! Don't worry how about the alternative route?";
			
			// or if u want to rethrow and let the main app handle this below will work if u throw in here u have to try catch in main app
			throw e;
		}
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long processDuration = end - begin;
		
		myLogger.info("Method runs completed time = " + processDuration / 1000 + " seconds");
		myLogger.info("------>>>>>.AOP DEBUGGING LOGS ENDS");
		return result;
	}
	
	@After("execution(* com.mars.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoin) {
		
		
		// print out which method we are advicing on 
				String methodName = theJoin.getSignature().toShortString();
				myLogger.info("@After finally : Method name : " + methodName);
				
				// u not able to access exception in after finally if u want exception, use afterThrowing 
		
		
	}
	
	
	@AfterThrowing(pointcut = "execution(* com.mars.aop.dao.AccountDAO.findAccounts(..))",
					throwing = "excep"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoin, Throwable excep) {
		
		// print out which method we are advicing on 
		String methodName = theJoin.getSignature().toShortString();
	//	myLogger.info("@AfterThrowing : Method name : " + methodName);
		
		
		// print out the results of the method call
		//myLogger.info("exception msg: " + excep);
		
	}
	
		
	//// returning and parameter name should match
	@AfterReturning(pointcut = "execution(* com.mars.aop.dao.AccountDAO.findAccounts(..))",
					returning = "result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint theJoin, List<Account> result) {
		//display the method name/ printout which method we are advicing on
		String method =theJoin.getSignature().toShortString();	//this will return the method name
		
		myLogger.info("@AfterRetuning: Method Name: " + method);
		myLogger.info("Result: " + result);
		
		// post-processing the data / modify the data
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
	
		myLogger.info("Prcoessed/Modified Result: " + result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		// Loop through accounts
		
		for(Account curAccount : result) {
		
			// get uppercase version of anme
			String theUpperCase = curAccount.getName().toUpperCase();
			
			// update the name on the account
			curAccount.setName(theUpperCase);
		}
	}

	@Before("com.mars.aop.aspect.marsAopExpression.daoPackageNoGetterSetter()")
	public void beforeAddingAnyAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n +++AOP+++ \n====>>> Executing @Before advice on addAccount()\n +++++++++ \n");
		
		//display the method name
		MethodSignature mySignature = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("@Before: Method: " + mySignature);
		
		
		//display mthod arguments
		
		// get arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through arguments
		for(Object currentArg : args) {
			myLogger.info(currentArg.toString());
			if (currentArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) currentArg;
				myLogger.info("Account holder name: " + theAccount.getName());
				myLogger.info("Account holder level: " + theAccount.getLevel());
			}
		}
		
	}
	
	
}
