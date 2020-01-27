package com.mars.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("thatBigilCoach")
public class FootballCoach implements Coach {

	FortuneService fortune;

	// setter inject
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortune(FortuneService fortune) {
		this.fortune = fortune;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice hard cup important pa";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortune.getFortune();
	}

}
