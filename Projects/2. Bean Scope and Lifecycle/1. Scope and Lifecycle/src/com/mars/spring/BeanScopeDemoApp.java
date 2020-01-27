package com.mars.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		/*
		 * Spring container default scope is Singleton and it's only one instance
		 * prototype scope : which will create new one for each request
		 * 
		 */

		// Load the spring configuration file

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope_applicationContext.xml");
		// retrieve bean from spring container

		Coach theCoach = context.getBean("myCoach", Coach.class);

		Coach theAlphaCoach = context.getBean("myCoach", Coach.class);

		/// checking if they are poiting to the same object
		boolean checkIsSame = (theCoach == theAlphaCoach);

		System.out.println("Is Pointing to the Same Object? \n" + checkIsSame);

		System.out.println("Memory Location for theCoach : " + theCoach);
		System.out.println("Memory Location for theAlphaCoach : " + theAlphaCoach);

	}

}
