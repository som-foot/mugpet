package com.somfoot.mugpet.entity;

import com.somfoot.mugpet.dto.ItemFormDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="ITEM")
@Getter @Setter
@NoArgsConstructor
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
	private int stockNum; 				//상품 재고

	@Builder
	public Item(Long id,int category_id, int spe_id, String itemName, int price, String brand,
			String itemDetail,int stockNum) {
		this.id = id;
		this.category_id = category_id;
		this.spe_id = spe_id;
		this.itemName = itemName;
		this.price = price;
		this.brand = brand;
		this.itemDetail = itemDetail;
		this.stockNum = stockNum;
	}

	public void updateItem (ItemFormDto itemFormDto) {
		this.itemName = itemFormDto.getItemName();
		this.itemDetail = itemFormDto.getItemDetail();
		this.brand = itemFormDto.getBrand();
		this.category_id = itemFormDto.getCategory_id();
		this.spe_id = itemFormDto.getSpe_id();
		this.stockNum = itemFormDto.getStockNum();
		this.price = itemFormDto.getPrice();

	//1:1 양방향 연관관계
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "item_id")
	private Filter filter;

	public Item() {}

//     @Builder(builderMethodName = "itemBuilder")

//     public Item(long item_id, int category, int species, String itemName) {
//       this.item_id = item_id;
//       this.category = category;
//       this.species = species;
//       this.itemName = itemName;

//     }}
