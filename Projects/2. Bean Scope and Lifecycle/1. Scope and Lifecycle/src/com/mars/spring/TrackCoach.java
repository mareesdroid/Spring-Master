package com.mars.spring;

/**
 * @author mars
 *
 */
public class TrackCoach implements Coach {

	private FortuneServices fortune;

	public TrackCoach(FortuneServices fortune) {
		this.fortune = fortune;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "go for a super 5k run";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just Do it : " + fortune.getFortune();
	}

	// add an init method
	public void doMyStartupStuff() {
		System.out.println("Track Coach : init");
	}

	// add a destroy method
	public void doMyFinishStuff() {
		System.out.println("Track Coach : cleanup");
	}

}
