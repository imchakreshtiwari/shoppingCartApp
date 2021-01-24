package com.shop.shoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.shoppingCart.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
