package com.mars.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mars.entity.Customer;
import com.mars.entity.Response;
import com.mars.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	//  autowire the customerService
	@Autowired
	private CustomerService customerService;
	
	// mapping for GET /customers
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	
	// mapping for  GET /customers/{customerId}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer myCustomer = customerService.getCustomer(customerId); 
		
		if(myCustomer == null) {
			throw new CustomerNotFoundException("customer id not found - " + customerId);
		}
		return myCustomer;
	}
	
	// mapping for POST /customers
	
	@PostMapping("/customers")
	public Response addCustomer(@RequestBody Customer theCustomer) {
		// just in case paas an id by zero
		//  this is force save of new item ...instead of updating
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return new Response(HttpStatus.CREATED.value(),"Added Successfully",System.currentTimeMillis());
	}
	
	
	// Mapping for PUT /customers
	
	@PutMapping("/customers")
	public Response updateCustomer(@RequestBody Customer theCustomer) {
		// saveOrUpdate() is called
		customerService.saveCustomer(theCustomer);
		return new Response(HttpStatus.CREATED.value(),"Updated Successfully",System.currentTimeMillis());
	}
	
	
	// Mapping for DELETE /customers
	
	@DeleteMapping("/customers/{customerId}")
	public Response deleteCustomer(@PathVariable int customerId) {
		Customer myCustomer = customerService.getCustomer(customerId); 
		
		if(myCustomer == null) {
			throw new CustomerNotFoundException("customer id not found - " + customerId);
		}
		customerService.deleteCustomer(customerId);
		return new Response(HttpStatus.OK.value(),"Deleted Successfully",System.currentTimeMillis());
	}
	
}
