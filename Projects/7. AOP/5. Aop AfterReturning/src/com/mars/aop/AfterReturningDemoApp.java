package com.mars.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mars.aop.dao.AccountDAO;
import com.mars.aop.dao.MembershipDAO;


public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		
		// read spring  config java class
		AnnotationConfigApplicationContext context = 
							new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);		///default bean name is class name if u want to change change it in @Component(name = "helloBean")

		// get accounts
		List<Account> myAcoounts = theAccountDAO.findAccounts();
		//theAccountDAO.test();
		
	//	theAccountDAO.doingWork();
		// print the accounts
		
		System.out.println(myAcoounts);
		
		
		
		
		//close the context
		context.close();

	}

}
