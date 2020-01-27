package com.mars.spring;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	@Value("${foo.email}")
	private String mail;
	@Value("${foo.team}")
	private String team;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warmup.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortuneSevice();
	}

	public String getMail() {
		return mail;
	}

	public String getTeam() {
		return team;
	}

}
