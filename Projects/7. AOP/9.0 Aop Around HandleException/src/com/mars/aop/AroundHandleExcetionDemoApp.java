package com.mars.aop;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mars.aop.dao.AccountDAO;
import com.mars.aop.dao.MembershipDAO;
import com.mars.aop.service.TrafficFortuneService;


public class AroundHandleExcetionDemoApp {


	private static Logger myLogger = Logger.getLogger(AroundHandleExcetionDemoApp.class.getName());
	
	
	public static void main(String[] args) {
		
		
		// read spring  config java class
		AnnotationConfigApplicationContext context = 
							new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		
		TrafficFortuneService trafficService = context.getBean("trafficFortuneService", TrafficFortuneService.class);		///default bean name is class name if u want to change change it in @Component(name = "helloBean")
		
		
		

		
		myLogger.info("Please wait while calculating the traffic status...");
		
		boolean tripWire = true;
		
		/*
		 * if u want to let AOP handle the exception use this
		String data = trafficService.getFortune(tripWire);
		myLogger.info("Traffic Status: " + data);
		*/
		
		
		/*
		 * if u want to let the main app handle the exception use this
		 */

		String data = "";
		
		try {
			data = trafficService.getFortune(tripWire);
		} catch(Exception e){
			data = "Major Accident highway closed! Don't worry how about the alternative route?";
		}
		
		System.out.println(data);
		//close the context
		context.close();

	}

}
