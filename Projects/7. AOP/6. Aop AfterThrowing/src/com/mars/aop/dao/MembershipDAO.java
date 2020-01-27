package com.mars.aop.dao;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
public class MembershipDAO {
	public void addMemberAccount() {
		System.out.println(getClass() + " DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
	}
	
	public void goingSleep() {
		System.out.println(getClass() + " DOING STUFF: Going to Sleep....Goodnight!");
	}
}
