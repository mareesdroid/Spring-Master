package com.mars.spring;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortuneSevice() {

		return "Today is a sad day";
	}

}
