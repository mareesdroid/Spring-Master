package com.mars.aop.dao;

import org.springframework.stereotype.Component;

import com.mars.aop.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount, boolean isVIP) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public void doingWork() {
		System.out.println(getClass() + " DOING STUFF: Kinda busy! catch u later!");
	}
}
