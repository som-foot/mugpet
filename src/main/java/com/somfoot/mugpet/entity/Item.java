package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "ITEM")
@Getter
@Setter
public class Item implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long item_id;				//primary key
	private int category_id;			//item이 속한 category id
	private int spe_id;					//반려동물 종 id
	private String itemName;			//상품명
	private int price;					//가격
	private String brand;				//브랜드
	private String imageUrl;			//이미지 경로
	private String comments;			//상품 설명글

	public Item() {}

	public Item(int item_id, int category_id, int spe_id, String itemName, int price, String brand, String imageUrl,
			String comments) {
		this.item_id = item_id;
		this.category_id = category_id;
		this.spe_id = spe_id;
		this.itemName = itemName;
		this.price = price;
		this.brand = brand;
		this.imageUrl = imageUrl;
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", category_id=" + category_id + ", spe_id=" + spe_id + ", itemName="
				+ itemName + ", price=" + price + ", brand=" + brand + ", imageUrl=" + imageUrl + ", comments="
				+ comments + "]";
	}
}
