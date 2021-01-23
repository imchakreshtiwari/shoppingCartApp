package com.shop.shoppingCart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.shoppingCart.dto.Token;
import com.shop.shoppingCart.entity.Customer;
import com.shop.shoppingCart.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "/signup")
	public void addCoachingDetails(@RequestBody Customer customer) {

		log.info("Calling api to add user");

		customerService.addCustomer(customer);

	}

	@GetMapping(value = "/login")
	public Token addCoachingDetails(@RequestBody Token token) {

		log.info("Calling api to login");

		Token token1 = customerService.doLogin(token);

		return token1;

	}

}
