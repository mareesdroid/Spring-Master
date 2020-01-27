package com.mars.spring;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortuneSevice() {
		// TODO Auto-generated method stub
		return "Today is your lucky day";
	}

}
