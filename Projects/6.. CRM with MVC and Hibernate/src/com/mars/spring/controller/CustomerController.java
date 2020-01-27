package com.mars.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mars.spring.dao.CustomerDAO;
import com.mars.spring.entity.Customer;
import com.mars.spring.service.CustomerService;




@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the dao
		List<Customer> theCustomers = customerService.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String addCustomer(Model theModel) {
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		
		
		
		return "customer-form";
	}
	
	// function name as same as the action see the jsp file 
	@PostMapping("/saveCustomer")
	public String saveTheCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		
		System.out.println("@saveCustomer"+theCustomer);
		// save the customer using our service
		customerService.saveCustomer(theCustomer);
	
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdatePage(@RequestParam("customerId") int theId, Model theModel) {
		
		// get the customer info from db
		Customer theCustomer = customerService.getCustomer(theId); 
		
		//set customer as a model attribute to prepopulate the form when page loads
		theModel.addAttribute("customer", theCustomer);
		//send our form
		System.out.println("@showUpdatePage"+theCustomer);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		// delegate to service
		customerService.deleteCustomer(theId);
		
		System.out.println("@Controller : Successfully deleted from db");
		
		// redirect to customer list after deleting
		return "redirect:/customer/list";
	}
}


