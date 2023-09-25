package com.somfoot.mugpet.entity;

import com.somfoot.mugpet.repository.CartRepository;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Cart {

	private Map<String, CartItem> cartItemMap = Collections.synchronizedMap(new HashMap<String, CartItem>());

	public Cart() {}

	@Transactional
	public void addItem(Item item){
		//Map에 Item 추가
		CartItem cartItem = cartItemMap.get(item.getId());
		if(cartItem == null){
			cartItem = new CartItem();
			cartItem.setItem(item);
			cartItem.setQuantity(0);
			cartItemMap.put(Long.toString(item.getId()), cartItem);

		}
		cartItem.incrementQuantity();
	}

	public Item removeItemById(String itemId) {
		CartItem cartItem = cartItemMap.remove(itemId);
		if (cartItem == null)
			return null;
		else
			return cartItem.getItem();
	}

	public void incrementQuantityByItemId(String itemId) {
		CartItem cartItem = cartItemMap.get(itemId);
		cartItem.incrementQuantity();
	}

	public void setQuantityByItemId(String itemId, int quantity) {
		CartItem cartItem = cartItemMap.get(itemId);
		cartItem.setQuantity(quantity);
	}

//	public double getSubTotal() {
//
//	}

}