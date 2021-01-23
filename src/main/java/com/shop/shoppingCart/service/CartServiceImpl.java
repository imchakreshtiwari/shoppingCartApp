package com.shop.shoppingCart.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.shoppingCart.entity.Cart;
import com.shop.shoppingCart.entity.Items;
import com.shop.shoppingCart.repository.CartRepository;
import com.shop.shoppingCart.repository.ItemRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
public class CartServiceImpl implements CartService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private HttpSession httpSession;


	@Override
	public void addItemToCart(Cart cart) {

		httpSession.putValue("cart", cart.getItems());
		cartRepository.save(cart);
	}

	@Override
	public void removeItemFromCart(Cart cart) {

		Set<Items> items = cart.getItems();
		for (Items item : items) {
			cartRepository.deleteFromCart(item.getId());
		}
	}

	@Override
	public List<Items> getAllItem() {
		List<Items> items = new ArrayList<>();
		List<Cart> carts = cartRepository.findAll();
		for (Cart cart : carts) {
			items.addAll(cart.getItems());
		}
		return items;
	}

}
