package com.lti.assign2banking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.assign2banking.model.Customer;
import com.lti.assign2banking.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer cust) {
		return customerRepository.save(cust);
	}
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	public String deleteCustomer(Long id) {
		customerRepository.deleteById(id);
		return "Success";
	}
	public Optional<Customer> getById(Long cust) {
		return customerRepository.findById(cust);
	}
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

}
