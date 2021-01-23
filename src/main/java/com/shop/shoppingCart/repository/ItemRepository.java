package com.shop.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.shoppingCart.entity.Items;

public interface ItemRepository extends JpaRepository<Items, Long>{

	@Query("select e FROM Items e ORDER BY price ASC")
	List<Items> findAllOrderByPriceAsc();
	
	@Query("select e FROM Items e ORDER BY itemName ASC")
	List<Items> findAllOrderByItemNameAsc();
}
