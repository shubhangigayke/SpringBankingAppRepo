package com.lti.assign2banking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 
import com.lti.assign2banking.model.Customer;
import com.lti.assign2banking.service.CustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand; 

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {
	@Autowired 
	CustomerService customerService;
	
	@RequestMapping("/getDetails")
	@HystrixCommand(fallbackMethod = "getDataFallback")
	public String getDetails() {
		if (false) {
			throw new RuntimeException();
		}
		return "Some Data";
	}

	public String getDataFallback() {
		System.out.println("in Fallback");
		return "Fallback Data";
	}
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/getCustomerById/{custId}")
	public Optional<Customer> getCustomerById(@PathVariable Long custId){
		return customerService.getById(custId);
	} 
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@DeleteMapping("/deleteCustomerById/{custId}")
	public String deleteCustomerById(@PathVariable Long custId){
		return customerService.deleteCustomer(custId);
	}
}
