package com.mars.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	FortuneService fortune;
//	Setter inject
//	@Autowired
//	public void setFortune(FortuneService fortune) {
//		this.fortune = fortune;
//	}

//	// Constructor inject
//	@Autowired
//	public CricketCoach(FortuneService fortune) {
//		super();
//		this.fortune = fortune;
//	}

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
