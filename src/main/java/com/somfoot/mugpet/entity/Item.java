package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="item")
@Getter @Setter
public class Item {

	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;				//primary key
	private int category_id;			//item이 속한 category id
	private int spe_id;					//반려동물 종 id
	private String itemName;			//상품명
	private int price;					//가격
	private String brand;				//브랜드
	private String itemDetail;			//상품 설명글

	public Item() {}

	@Builder
	public Item(int id, int category_id, int spe_id, String itemName, int price, String brand, String imageUrl,
			String itemDetail) {
		this.id = id;
		this.category_id = category_id;
		this.spe_id = spe_id;
		this.itemName = itemName;
		this.price = price;
		this.brand = brand;
		this.itemDetail = itemDetail;
	}

}
