package com.mars.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		// Create a Student Object
		Student myStudent = new Student();
		// creating a new Student object and add that object to model
		theModel.addAttribute("student", myStudent);
		// returning the student-form.jsp go there
		return "student-form";

	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student myStudent) {
		// after submited and set data to the model
		// here we get Student object from model key should match("student")

		// log
		System.out.println("Student : " + myStudent.getFirstName() + " " + myStudent.getLastName());

		// go to student-confirmation.jsp
		return "student-confirmation";
	}

}
