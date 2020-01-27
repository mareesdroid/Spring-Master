package com.mars.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach {

	// autowiring fields
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortune;

	// autowire any method
	@Autowired
	public void doSomeAutoWireWorkWhenever() {
		System.out.println("Hey I can run when context instantiated because I'm Autowired");
	}

	public String getMyFortune() {
		return fortune.getFortune();
	}

}
