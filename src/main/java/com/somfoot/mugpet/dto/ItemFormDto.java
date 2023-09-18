package com.somfoot.mugpet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemFormDto {

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
}
