package com.shop.shoppingCart.service;

import com.shop.shoppingCart.dto.Token;
import com.shop.shoppingCart.entity.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer);
	
	public Token doLogin(Token token);
}
