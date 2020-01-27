package com.mars.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	FortuneService fortune;

	@Autowired
	public void setFortune(FortuneService fortune) {
		this.fortune = fortune;
	}

	/// without specifying annotation name we can use class name as bean id
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice Fast Bowling";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortune.getFortune();
	}

}
