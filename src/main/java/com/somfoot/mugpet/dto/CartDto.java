package com.somfoot.mugpet.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartDto {
    @Id
    @Column(name="cart_id")
    private long id;		//primary key(cartId)
    //private int cart_id;
    @Column(unique = true)
    private int item_id;	//카트에 담은 item의 id
    private int total;		//총 가격(상품 가격 * 개수)
    private int cartQty;	//개수
    private int u_id;		//로그인한 사용자 id
}
