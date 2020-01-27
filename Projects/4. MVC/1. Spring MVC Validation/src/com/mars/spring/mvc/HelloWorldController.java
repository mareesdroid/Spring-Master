package com.mars.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	/////// read dorm data modify and send to model

	// read form data and add it to the model
	@RequestMapping("/processFormTwo")
	public String processFormTwo(HttpServletRequest request, Model model) {

		// read the request parameter from the html form
		String name = request.getParameter("studentName");
		// convert the data to all caps
		name = name.toUpperCase();
		// create the message
		String result = "Yo! " + name;
		// add the message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}

///////read dorm data modify and send to model With Annotation

	@RequestMapping("/processFormThree")
	public String processFormThree(@RequestParam("studentName") String name, Model model) {

		// convert the data to all caps
		name = name.toUpperCase();
		// create the message
		String result = "Howdy! " + name;
		// add the message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}

}
