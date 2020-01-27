package com.mars.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanCycleDemoApp {

	public static void main(String[] args) {

		/*
		 * Spring container default scope is Singleton and it's only one instance
		 * prototype scope : which will create new one for each request
		 * 
		 */

		// Load the spring configuration file

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanCycle_applicationContext.xml");
		// retrieve bean from spring container

		Coach theCoach = context.getBean("myCoach", Coach.class);

		context.close();

	}

}
