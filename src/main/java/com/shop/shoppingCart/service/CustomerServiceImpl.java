package com.shop.shoppingCart.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.shoppingCart.dto.Token;
import com.shop.shoppingCart.entity.Customer;
import com.shop.shoppingCart.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void addCustomer(Customer customer) {

		String password = hashPassword(customer.getPassword());
		customer.setPassword(password);
		customerRepository.save(customer);
	}

	private String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	@Override
	public Token doLogin(Token token) {

		String password = hashPassword(token.getPassword());
		boolean res = checkPass(token.getPassword(), password);
		if (!res) {
			System.out.println("Password Incorrect !"); // throw exception
		}
		String newtoken = generateToken(token.getEmail());
		Token token1 = new Token();
		token1.setToken(newtoken);
		return token1;
	}

	private boolean checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			return true;
		else
			return false;
	}
	
	private String generateToken(String email) {
		String token = email + Math.random();
		return token;
 	}
}
