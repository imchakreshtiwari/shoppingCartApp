package com.shop.shoppingCart.service;

import java.util.List;

import com.shop.shoppingCart.entity.Cart;
import com.shop.shoppingCart.entity.CartItem;

public interface CartService {

	public void addItemToCart(Cart cart);
	
	public void removeItemFromCart(Cart cart);
	
	public void editItemQuantity(Cart cart);
	
	public List<CartItem> getAllItem();
	
	public Long doCheckOut(Cart cart);
	
	public void	confirmOrder();
	
}
