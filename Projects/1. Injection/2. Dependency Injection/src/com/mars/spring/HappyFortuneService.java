package com.mars.spring;

/**
 * @author mars
 *
 */
public class HappyFortuneService implements FortuneServices {

	@Override
	public String getFortune() {

		return "Today is your lucky day!";
	}

}
