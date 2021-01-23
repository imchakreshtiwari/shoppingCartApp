package com.shop.shoppingCart.service;

import java.util.List;

import com.shop.shoppingCart.entity.Items;

public interface ItemsService {

	void addItem(Items items);
	
	Items getItem(Long id);
	
	List<Items> getAllItems();
	
	List<Items> itemsSortedByPrice();
	
	List<Items> itemsSortedByName();
}
