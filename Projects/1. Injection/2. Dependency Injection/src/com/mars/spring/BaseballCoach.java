package com.mars.spring;

/**
 * @author mars
 *
 */
public class BaseballCoach implements Coach {
	
	FortuneServices fortune;
	
	public BaseballCoach(FortuneServices myFortune) {
		this.fortune = myFortune;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice.";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		
		return fortune.getFortune();
	}
 
}
