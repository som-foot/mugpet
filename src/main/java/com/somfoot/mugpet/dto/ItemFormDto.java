package com.somfoot.mugpet.dto;

import com.somfoot.mugpet.entity.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ItemFormDto {


    private Long id;
    @NotBlank
    private int category_id;			//item이 속한 category id
    @NotBlank
    private int spe_id;					//반려동물 종 id
    @NotBlank
    private String itemName;			//상품명
    @NotBlank
    private int price;					//가격
    @NotEmpty
    private String brand;				//브랜드
    @NotEmpty
    private String itemDetail;			//상품 설명글

    @NotEmpty
    private int stockNum;                  //상품 개수

    private List<ItemImgDto> ItemImgDtos = new ArrayList<>();

    public ItemFormDto() {}
    @Builder
    public ItemFormDto(Long id,int category_id, int spe_id, String itemName, int price,
                       String brand, String itemDetail,int stockNum) {
        this.id = id;
        this.category_id = category_id;
        this.spe_id = spe_id;
        this.itemName = itemName;
        this.price = price;
        this.brand = brand;
        this.itemDetail = itemDetail;
        this.stockNum = stockNum;
    }


    //FormDto 를 엔티티로 리턴해주는 메소드
    public Item toEntity(ItemFormDto itemFormDto) {
        Item item = Item.builder()
                .id(itemFormDto.id)
                .itemName(itemFormDto.itemName)
                .price(itemFormDto.price)
                .category_id(itemFormDto.category_id)
                .spe_id(itemFormDto.spe_id)
                .itemDetail(itemFormDto.itemDetail)
                .brand(itemFormDto.brand)
                .stockNum(itemFormDto.stockNum)
                .build();

        return item;
    }

    //엔티티를 FormDto로 리턴해주는 메소드
    public ItemFormDto of(Item item) {
        ItemFormDto itemFormDto = ItemFormDto.builder()
                .id(item.getId())
                .itemName(item.getItemName())
                .category_id(item.getCategory_id())
                .spe_id(item.getSpe_id())
                .brand(item.getBrand())
                .price(item.getPrice())
                .stockNum(item.getStockNum())
                .build();

        return itemFormDto;

    }




}
