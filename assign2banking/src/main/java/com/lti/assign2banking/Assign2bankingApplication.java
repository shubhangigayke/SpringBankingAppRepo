package com.lti.assign2banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
@EnableDiscoveryClient
public class Assign2bankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assign2bankingApplication.class, args);
	}

}
