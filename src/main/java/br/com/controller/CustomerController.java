package br.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.model.CustomerData;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@GetMapping("/customer/{userId}")
	public CustomerData getCustomarProfile(@PathVariable("userId") String userId) {
		return getCustcomer(userId);
	}

	private CustomerData getCustcomer(final String userId) {
		CustomerData customer = new CustomerData();
		customer.setEmail("eder123@gmail.com");
		customer.setFirstName("Eder");
		customer.setFirstName("Carlos");
		customer.setAge(38);
		customer.setAge(userId);
		return customer;
	}

}
