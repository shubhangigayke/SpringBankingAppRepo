package com.lti.assign2banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.assign2banking.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
