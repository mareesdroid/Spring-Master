package com.mars.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	
	@After("execution(* com.mars.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoin) {
		
		
		// print out which method we are advicing on 
				String methodName = theJoin.getSignature().toShortString();
				System.out.println("@After finally : Method name : " + methodName);
				
				// u not able to access exception in after finally if u want exception, use afterThrowing 
		
		
	}
	
	
	@AfterThrowing(pointcut = "execution(* com.mars.aop.dao.AccountDAO.findAccounts(..))",
					throwing = "excep"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoin, Throwable excep) {
		
		// print out which method we are advicing on 
		String methodName = theJoin.getSignature().toShortString();
	//	System.out.println("@AfterThrowing : Method name : " + methodName);
		
		
		// print out the results of the method call
		//System.out.println("exception msg: " + excep);
		
	}
	
		
	//// returning and parameter name should match
	@AfterReturning(pointcut = "execution(* com.mars.aop.dao.AccountDAO.findAccounts(..))",
					returning = "result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint theJoin, List<Account> result) {
		//display the method name/ printout which method we are advicing on
		String method =theJoin.getSignature().toShortString();	//this will return the method name
		
		System.out.println("@AfterRetuning: Method Name: " + method);
		System.out.println("Result: " + result);
		
		// post-processing the data / modify the data
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
	
		System.out.println("Prcoessed/Modified Result: " + result);
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
		System.out.println("\n +++AOP+++ \n====>>> Executing @Before advice on addAccount()\n +++++++++ \n");
		
		//display the method name
		MethodSignature mySignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("@Before: Method: " + mySignature);
		
		
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
