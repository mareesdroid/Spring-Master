package com.mars.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mars.aop.Account;

@Component
public class AccountDAO {
	
	private String name, serviceCode;
	
	
	// add a new method: findAccounts()
	
	public List<Account> findAccounts(){
		List<Account> myAccounts = new ArrayList<>();
		
		//Create Sample Accounts
		Account tempAccount1 = new Account("Marees","Platinum");
		Account tempAccount2 = new Account("Yuvaraj", "Diamond");
		Account tempAccount3 = new Account("Elavarasan", "Gold");
		
		// add them to our account list
		
		myAccounts.add(tempAccount1);
		myAccounts.add(tempAccount2);
		myAccounts.add(tempAccount3);
		return myAccounts;
	}
	public void test() {
		
	}
	
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
