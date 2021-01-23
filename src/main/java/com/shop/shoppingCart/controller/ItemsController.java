package com.shop.shoppingCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.shoppingCart.entity.Items;
import com.shop.shoppingCart.service.ItemsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;

	@PostMapping(value = "/item")
	public void addItems(@RequestBody Items items) {

		log.info("Calling api to add item");

		itemsService.addItem(items);

	}

	@GetMapping(value = "/item/{id}")
	public Items getItemsById(@PathVariable("id") Long id) {

		log.info("Calling api to get item by id");

		Items item = itemsService.getItem(id);

		return item;

	}
	
	@GetMapping(value = "/items")
	public List<Items> getItems() {

		log.info("Calling api to get all items");

		List<Items> items = itemsService.getAllItems();

		return items;

	}
	
	@GetMapping(value = "/itemsbyprice")
	public List<Items> getItemsByPrice() {

		log.info("Calling api to get all items sorted by Price");

		List<Items> items = itemsService.itemsSortedByPrice();

		return items;

	}
	
	@GetMapping(value = "/itemsbyname")
	public List<Items> getItemsByName() {

		log.info("Calling api to get all items sorted by name");

		List<Items> items = itemsService.itemsSortedByName();

		return items;

	}
}
