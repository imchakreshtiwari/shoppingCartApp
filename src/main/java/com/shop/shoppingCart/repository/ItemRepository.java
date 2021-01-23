package com.shop.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.shoppingCart.entity.Items;

public interface ItemRepository extends JpaRepository<Items, Long>{

	List<Items> findAllOrderByPriceAsc();
	
	List<Items> findAllOrderByItemNameAsc();
}
