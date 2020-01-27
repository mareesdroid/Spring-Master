package com.mars.spring;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortune;

	// create an array of strings
	private String[] data = { "Beware of the Wolf in Sheep's Clothing", "Dilegence is the mother of good luck",
			"The journey is the reward" };

	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		int index = myRandom.nextInt(data.length);
		return data[index];
	}

}
