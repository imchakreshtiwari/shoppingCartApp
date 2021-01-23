package com.shop.shoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.shoppingCart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

	@Query(value = "delete from Cart c where c.items.id = :itemId")
	public void deleteFromCart(@Param("itemId") Long itemId);
}
