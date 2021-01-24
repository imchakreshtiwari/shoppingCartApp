package com.shop.shoppingCart.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.shoppingCart.entity.Cart;
import com.shop.shoppingCart.entity.CartItem;
import com.shop.shoppingCart.service.CartService;
import com.shop.shoppingCart.service.SendMailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	SendMailService sendMailService;
	
	@RequestMapping(value = "/sendemail")
	public String sendEmail() throws AddressException, MessagingException, IOException {
		
		log.info("Calling Mail API to send Email");
		sendMailService.sendingMail("chakresh@acis.io", "Message From XYZ", "BODY");
		return "EmailFrom shopping Cart Sent Successfully";
	}
	
	@PostMapping(value = "/addItem")
	public void addItems(@RequestBody Cart cart) {

		log.info("Calling api to add item");

		cartService.addItemToCart(cart);

	}

	@PostMapping(value = "/removeItem")
	public void removeItem(@RequestBody Cart cart) {

		log.info("Calling api to get item by id");

		cartService.removeItemFromCart(cart);

	}
	
	@GetMapping(value = "/cartitems")
	public List<CartItem> getItems() {

		log.info("Calling api to get all items");

		List<CartItem> items = cartService.getAllItem();

		return items;

	}
	
	
	@PutMapping(value = "/editItems")
	public void editItems(@RequestBody Cart cart) {

		log.info("Calling api to edit Items in cart");

		cartService.editItemQuantity(cart);

	}
	
	@PostMapping(value = "/checkOut")
	public void checkOut(@RequestBody Cart cart) {

		log.info("Calling api to get all items");

		cartService.doCheckOut(cart);
	}
	
	@GetMapping(value = "/confirmOrder")
	public void confirmOrder() {

		log.info("Calling api to get confirm order");

		cartService.confirmOrder();

	}
	
}
