package com.somfoot.mugpet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//Entity는 아니고 그냥 클래스 타입으로 쓰기위한 클래스 (o_id, u_id 없음)
@Getter @Setter
public class OrderItemInfos {


	private int item_id;
	private String orderAddr;
	private int orderQty;
	private String req;
	private int itemPrice;
	private int applyPoints;
	private String itemName;
	private String imageUrl;
	
}
