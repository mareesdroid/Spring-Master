package com.mars.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemo {

	public static void main(String[] args) {

		// read spring config file

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		Coach theCoach = context.getBean("cricketCoach", Coach.class);
		Coach theAlphaCoach = context.getBean("cricketCoach", Coach.class);

		if (theCoach == theAlphaCoach) {
			System.out.println("Singleton Scope");
		} else {
			System.out.println("Prototype Scope");
		}

		// close the context
		context.close();

	}

}
