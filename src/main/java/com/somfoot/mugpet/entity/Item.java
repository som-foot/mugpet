package com.somfoot.mugpet.entity;

import com.somfoot.mugpet.etc.Category;
import com.somfoot.mugpet.etc.Species;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="ITEM")
@Getter @Setter
public class Item implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long item_id;				//primary key
	private int category;				//item이 속한 category
	private int species;					//반려동물 종
	private String itemName;			//상품명
	private int price;					//가격
	private String brand;				//브랜드
	private String imgUrl;				//이미지url
	private String itemDetail;			//상품 설명글

	//1:1 양방향 연관관계
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "item_id")
	private Filter filter;

	public Item() {}

	@Builder(builderMethodName = "itemBuilder")

	public Item(long item_id, int category, int species, String itemName) {
		this.item_id = item_id;
		this.category = category;
		this.species = species;
		this.itemName = itemName;
	}
}
