package com.mars.aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Moderate";
	}

	public String getFortune(boolean tripWire) {
		// TODO Auto-generated method stub
		
		if(tripWire) {
			throw new RuntimeException("Major Accident! Highway is closed!");
		}
		
		return getFortune();
	}
	
}
