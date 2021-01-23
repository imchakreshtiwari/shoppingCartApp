package com.shop.shoppingCart.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.shoppingCart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

	@Modifying
	@Transactional
	@Query(value = "delete from cart  where items_id= :itemId", nativeQuery = true)
	public void deleteFromCart(@Param("itemId") Long itemId);
}
