package com.shop.shoppingCart.service;

import java.util.List;

import com.shop.shoppingCart.entity.Cart;
import com.shop.shoppingCart.entity.Items;

public interface CartService {

	public void addItemToCart(Cart cart);
	
	public void removeItemFromCart(Cart cart);
	
	public List<Items> getAllItem();
	
}
