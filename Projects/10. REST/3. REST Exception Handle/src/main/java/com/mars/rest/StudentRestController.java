package com.mars.rest;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mars.entity.Student;
import com.mars.entity.StudentErrorResponse;
import com.mars.exhandler.StudenNotFoundException;

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
		
		// check the studentId against the list size
		if( (studentId >= theStudents.size()) || (studentId < 0)) {
																/// this will call the handleException(StudenNotFoundException e) method
			throw new StudenNotFoundException("Student not found - " + studentId);
		}
													// if any other exception occured automatically throws Exception
													// so we handle any other exception occured handleExceptionAll(Exception e) this method will Call
		return theStudents.get(studentId);
	}
	
	
	// Add an exception handler using @ExceptionHandler
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudenNotFoundException e){
		
		// create a studenterror response
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		//return response entity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	// Add an exception handler   .... to catch any exception
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleExceptionAll(Exception e){
		
		// create a studenterror response
				StudentErrorResponse error = new StudentErrorResponse();
				error.setStatus(HttpStatus.BAD_REQUEST.value());
				error.setMessage(e.getMessage());
				error.setTimestamp(System.currentTimeMillis());
				
				//return response entity
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
}
