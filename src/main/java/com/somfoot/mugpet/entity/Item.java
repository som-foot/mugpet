package com.somfoot.mugpet.entity;

import com.somfoot.mugpet.dto.ItemFormDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="ITEM")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long item_id;				//primary key
	private int category;				//item이 속한 category
	private int species;				//반려동물 종
	private String itemName;			//상품명
	private int price;					//가격
	private String brand;				//브랜드
	private String imgUrl;				//이미지url
	private String itemDetail;			//상품 설명글
	private int stockNum; 				//상품 재고

	//상품정보 수정시 사용
	public void updateItem (ItemFormDto itemFormDto) {
		this.itemName = itemFormDto.getItemName();
		this.itemDetail = itemFormDto.getItemDetail();
		this.brand = itemFormDto.getBrand();
		this.category = itemFormDto.getCategory();
		this.species = itemFormDto.getSpecies();
		this.stockNum = itemFormDto.getStockNum();
		this.price = itemFormDto.getPrice();
	}

	//1:1 양방향 연관관계
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "item_id")
	private Filter filter;

	@Builder(builderMethodName = "itemBuilder")
	public Item(long item_id, int category, int species, String itemName, int price, String brand, String imgUrl, String itemDetail, int stockNum, Filter filter) {
		this.item_id = item_id;
		this.category = category;
		this.species = species;
		this.itemName = itemName;
		this.price = price;
		this.brand = brand;
		this.imgUrl = imgUrl;
		this.itemDetail = itemDetail;
		this.stockNum = stockNum;
		this.filter = filter;
	}
}
