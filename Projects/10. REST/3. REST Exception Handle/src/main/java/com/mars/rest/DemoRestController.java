package com.mars.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

	
	// for "/hello" endpoint
	@GetMapping("/hello")
	public String syaHello() {
		return "Hello World";
	}
	
	
}
