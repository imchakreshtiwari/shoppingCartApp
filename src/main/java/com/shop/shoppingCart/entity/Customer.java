package com.shop.shoppingCart.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String email;
	private String password;
	private Integer age;
	private String gender;
	
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Address> addresses;
	
}
