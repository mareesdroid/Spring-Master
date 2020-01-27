package com.mars.spring;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//before change
			//create the object
//		BaseballCoach theCoach = new BaseballCoach();
//		
//		// use the object
//		System.out.println(theCoach.getDailyWorkout());
		
		// After added support for multiple Coach
		//added interface
		//added gym coach
		//create the object
		Coach theCoach = new BaseballCoach();
		Coach gymCoach = new GymCoach();
		
		
		// use the object
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(gymCoach.getDailyWorkout());
	}

}
