package com.somfoot.mugpet.entity;

import com.somfoot.mugpet.dto.ItemFormDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="item")
@Getter @Setter
@NoArgsConstructor
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
	}
}
