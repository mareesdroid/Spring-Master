package com.mars.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read spring config file

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		Coach cricket = context.getBean("cricketCoach", Coach.class);
		Coach bigil = context.getBean("thatBigilCoach", Coach.class);

		HockeyCoach hockey = context.getBean("hockeyCoach", HockeyCoach.class);
		// call a method on the bean
		System.out.println(bigil.getDailyWorkout());
		System.out.println(cricket.getDailyWorkout());
		System.out.println("football : " + bigil.getDailyFortune());
		System.out.println("cricket : " + cricket.getDailyFortune());
		System.out.println("field :" + hockey.getMyFortune());

		// close the context
		context.close();

	}

}
