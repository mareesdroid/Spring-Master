package com.mars.spring;

public class CricketCoach implements Coach {

	private FortuneServices fortune;
	private String mail;
	private String team;

	public CricketCoach() {
		System.out.println("Inside Cricket Coach");
	}

	// setter method
	public void setFortuneService(FortuneServices fortune) {
		System.out.println("Inside Setter Method");
		this.fortune = fortune;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getMail() {
		return mail;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise bowling for 15mts";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortune.getFortune();
	}

}
