package com.mars.aop.dao;

import org.springframework.stereotype.Component;

import com.mars.aop.Account;

@Component
public class AccountDAO {
	
	private String name, serviceCode;
	
	public void addAccount(Account theAccount, boolean isVIP) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public void doingWork() {
		System.out.println(getClass() + " DOING STUFF: Kinda busy! catch u later!");
	}

	public String getName() {
		System.out.println(getClass() + ": Getting Name");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": Setting Name");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": Getting Servicecode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": Setting Servicecode");
		this.serviceCode = serviceCode;
	}
	
	
}
