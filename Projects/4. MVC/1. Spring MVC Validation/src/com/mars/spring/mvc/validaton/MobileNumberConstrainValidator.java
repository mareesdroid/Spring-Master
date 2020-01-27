package com.mars.spring.mvc.validaton;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileNumberConstrainValidator implements ConstraintValidator<MobileNumber, String> {

	private String mobilePrefix;

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		boolean result = false;
		if (arg0 != null) {
			result = arg0.startsWith(mobilePrefix);
		}
		return result;
	}

	@Override
	public void initialize(MobileNumber mobNumber) {

		mobilePrefix = mobNumber.value();
	}

}
