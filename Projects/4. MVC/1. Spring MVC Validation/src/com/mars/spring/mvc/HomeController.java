package com.mars.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String myHome() {
		return "index";
	}

	@RequestMapping("/contact_us")
	public String myContact() {
		return "contact";
	}

}
