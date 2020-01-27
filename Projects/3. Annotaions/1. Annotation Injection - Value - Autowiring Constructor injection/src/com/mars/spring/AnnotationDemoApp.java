package com.mars.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read spring config file

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		Coach bigil = context.getBean("thatBigilCoach", Coach.class);
		Coach cricket = context.getBean("cricketCoach", Coach.class);
		// call a method on the bean
		System.out.println(bigil.getDailyWorkout());
		System.out.println(cricket.getDailyWorkout());
		System.out.println(bigil.getDailyFortune());
		System.out.println(cricket.getDailyFortune());
		// close the context
		context.close();

	}

}
