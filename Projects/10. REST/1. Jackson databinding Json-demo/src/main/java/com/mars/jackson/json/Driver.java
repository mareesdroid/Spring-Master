package com.mars.jackson.json;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			//read JSON file and map/convert to java pojo: data/sample-lite.json
			 Students thestudents = mapper.readValue(new File("data/sample-full.json"), Students.class);
			 
			 Student[] studentList = thestudents.getStudents();
			for(Student curStuent : studentList) {
				System.out.println("===>> Student Info\n\n");
				studentPrinter(curStuent);
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public static void studentPrinter(Student student) {
		
			 
			// print first name and lastname
			 
			 System.out.println("First Name: " + student.getFirstName());
			 System.out.println("Last Name: " + student.getLastName());
			 
			 // print out address: street and city
			 System.out.println("===>> Student Address");
			 Address studentAddress = student.getAddress();
			 System.out.println("Street: " + studentAddress.getStreet());
			 System.out.println("City: " + studentAddress.getCity());
			 
			 // favourite languages
			 String[] language = student.getLanguages();
			 System.out.println("===>> Student Favorite Language");
			 for(String curLanguage : language) {
				 System.out.println(curLanguage);
			 }
			 System.out.println("\n\n");
		
	}
	
	
}


