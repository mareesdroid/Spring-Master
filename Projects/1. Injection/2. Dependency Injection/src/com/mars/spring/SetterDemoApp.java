package com.mars.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file

		ClassPathXmlApplicationContext contex = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container

		CricketCoach theCoach = contex.getBean("myCricketCoach", CricketCoach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getMail());
		System.out.println(theCoach.getTeam());

		/*
		 * from above get bean cricket coach istance created cricket coach constructor
		 * is called then the setter method is called now we can use the
		 * theCoach(factory data build for us).get
		 */

		// call methods on the bean

		// close the context

		contex.close();

	}

}
