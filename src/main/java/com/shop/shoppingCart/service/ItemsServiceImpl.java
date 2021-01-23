package com.shop.shoppingCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.shoppingCart.entity.Items;
import com.shop.shoppingCart.repository.ItemRepository;

@Service
public class ItemsServiceImpl implements ItemsService{

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public void addItem(Items items) {
		// TODO Auto-generated method stub
		itemRepository.save(items);
		
	}

	@Override
	public Items getItem(Long id) {
	
		Items items = itemRepository.findById(id).orElse(null);
		return items;
	}

	@Override
	public List<Items> getAllItems() {
		
		return itemRepository.findAll();
	}

	@Override
	public List<Items> itemsSortedByPrice() {
		
		return itemRepository.findAllOrderByPriceAsc();
	}

	@Override
	public List<Items> itemsSortedByName() {

		return itemRepository.findAllOrderByItemNameAsc();
	}
	
}
