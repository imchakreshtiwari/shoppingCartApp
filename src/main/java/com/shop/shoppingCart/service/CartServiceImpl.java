package com.shop.shoppingCart.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.shop.shoppingCart.entity.Cart;
import com.shop.shoppingCart.entity.CartItem;
import com.shop.shoppingCart.repository.CartRepository;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
public class CartServiceImpl implements CartService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private HttpSession httpSession;
	
	
	@Autowired
	SendMailService sendMailService;


	@Override
	public void addItemToCart(Cart cart) {

		httpSession.putValue("cart", cart.getItems());
		cartRepository.save(cart);
	}

	@Override
	public void removeItemFromCart(Cart cart) {

		Set<CartItem> items = cart.getItems();
		for (CartItem item : items) {
			cartRepository.deleteFromCart(item.getId());
		}
	}

	@Override
	public List<CartItem> getAllItem() {
		List<CartItem> items = new ArrayList<>();
		List<Cart> carts = cartRepository.findAll();
		for (Cart cart : carts) {
			items.add((CartItem) cart.getItems());
		}
		return items;
	}

	@Override
	public Long doCheckOut(Cart cart) {
		// TODO Auto-generated method stub
		Set<CartItem> items = cart.getItems();
		Long total = 0L;
		for (CartItem cartItem: items) {
			total += cartItem.getPrice() * cartItem.getQuantity();
		}
		
		try {
			sendMailService.sendingMail("chakresh@acis.io", "Message From XYZ", "BODY");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	@Override
	public void confirmOrder() {

		try {
			sendMailService.sendingMail("chakresh@acis.io", "Message From XYZ", "BODY");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void editItemQuantity(Cart cart) {
		
		Set<CartItem> items = cart.getItems();
		for (CartItem cartItem: items) {
			if (cartItem.getValue().equals("ADD")) {
				int newQuantity = cartItem.getQuantity() + 1;
				cartItem.setQuantity(newQuantity);
			}else {
				int newQuantity = cartItem.getQuantity() - 1;
				cartItem.setQuantity(newQuantity);
			}
			
		}
		cartRepository.save(cart);
	}

}
