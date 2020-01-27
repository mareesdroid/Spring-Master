package com.mars.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mars.aop.dao.AccountDAO;
import com.mars.aop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		
		// read spring  config java class
		AnnotationConfigApplicationContext context = 
							new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);		///default bean name is class name if u want to change change it in @Component(name = "helloBean")
		
		MembershipDAO theMember = context.getBean("membershipDAO", MembershipDAO.class);			
		// call he business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doingWork();
		
		theMember.addMemberAccount();
		theMember.goingSleep();
		
		
		
		//close the context
		context.close();

	}

}
