package com.shop.shoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.shoppingCart.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}