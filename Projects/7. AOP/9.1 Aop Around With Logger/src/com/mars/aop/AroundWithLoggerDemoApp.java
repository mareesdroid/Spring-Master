package com.mars.aop;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mars.aop.dao.AccountDAO;
import com.mars.aop.dao.MembershipDAO;
import com.mars.aop.service.TrafficFortuneService;


public class AroundWithLoggerDemoApp {


	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	
	public static void main(String[] args) {
		
		
		// read spring  config java class
		AnnotationConfigApplicationContext context = 
							new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		
		TrafficFortuneService trafficService = context.getBean("trafficFortuneService", TrafficFortuneService.class);		///default bean name is class name if u want to change change it in @Component(name = "helloBean")
		
		
		

		
		myLogger.info("Please wait while calculating the traffic status...");
		
		String data = trafficService.getFortune();
		
		myLogger.info("Traffic Status: " + data);
		
		
		
		
		//close the context
		context.close();

	}

}
