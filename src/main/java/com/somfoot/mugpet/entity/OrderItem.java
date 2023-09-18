package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="orderItem")
@Getter
@Setter
public class OrderItem {
	@Id
	@Column(name = "o_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;				//primary key(o_id)
	//private int o_id;				//primary key
	private int orderQty;			//구매하는 개수
	private String orderAddr;		//배송지
	private String orderPhoneNum; 	//전화번호
	private int item_id;			//구매한 item의 id
	private int itemPrice;			//구매한 아이템 당 개수를 고려한 가격
	private int applyPoints;		//적용한 적립금
	private String req;				//사용자 요청사항
	private String orderTime;		//주문한 시간
	private int u_id;				//로그인한 사용자 id

	private List<Cart> orderItemList;
	public OrderItem() {}
	
	public OrderItem(int orderQty, String orderAddr, String orderPhoneNum, int item_id, int itemPrice, int applyPoints, String req, int u_id) {		
		this.orderQty = orderQty;
		this.orderAddr = orderAddr;
		this.orderPhoneNum = orderPhoneNum;
		this.item_id = item_id;
		this.itemPrice = itemPrice;
		this.applyPoints = applyPoints;
		this.req = req;
		this.u_id = u_id;
		
	}
	public List<Cart> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<Cart> orderItemList) {
		this.orderItemList = orderItemList;
	}


	
	
}
