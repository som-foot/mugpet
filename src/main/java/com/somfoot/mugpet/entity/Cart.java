package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cart")
@Getter
@Setter
public class Cart {
	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;		//primary key(cartId)
	//private int cart_id;
	@Column(unique = true)
	private int item_id;	//카트에 담은 item의 id
	private int total;		//총 가격(상품 가격 * 개수)
	private int cartQty;	//개수
	private int u_id;		//로그인한 사용자 id
	
	public Cart() {}

	public Cart(int item_id, int total, int cartQty, int u_id) {
		this.item_id = item_id;
		this.total = total;
		this.cartQty = cartQty;
		this.u_id = u_id;
	}
}