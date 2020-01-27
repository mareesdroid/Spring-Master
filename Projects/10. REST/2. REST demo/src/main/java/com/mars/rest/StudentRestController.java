package com.mars.rest;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mars.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	
	
	// define post construct to load the student data... runs only once
	// postconstruct runs even before bean
	 @PostConstruct
	public void lodaData() {
		 	theStudents = new ArrayList<>();
		 	theStudents.add(new Student("Poornima", "Kumari"));
			theStudents.add(new Student("Marees", "Waran"));
			theStudents.add(new Student("Yoga", "Durai"));
	}
	
	/// for "/students" endpoint 
	//return student list
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return theStudents;
		
	}
	
	/// for "/students/{studentId}"
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {			////@pathvriable studentId and mapping studentId name should match
		
		
		return theStudents.get(studentId);
	}
	
	
}
