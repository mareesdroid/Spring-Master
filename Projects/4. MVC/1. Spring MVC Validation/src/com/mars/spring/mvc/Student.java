package com.mars.spring.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName, lastName, Country, favoriteLanguage;
	private String[] operatingSystems;
	private LinkedHashMap<String, String> countries;

	public Student() {
		countries = new LinkedHashMap<>();
		countries.put("US", "United States");
		countries.put("IN", "India");
		countries.put("FR", "France");
		countries.put("JP", "Japan");
		countries.put("UK", "United Kingdom");

	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getCountries() {
		return countries;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
