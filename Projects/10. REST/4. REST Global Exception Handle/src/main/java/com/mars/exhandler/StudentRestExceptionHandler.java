package com.mars.exhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mars.entity.StudentErrorResponse;

@ControllerAdvice
public class StudentRestExceptionHandler {

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
