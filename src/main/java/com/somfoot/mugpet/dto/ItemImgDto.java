package com.somfoot.mugpet.dto;

import com.somfoot.mugpet.entity.ItemImg;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ItemImgDto {


    private Long item_img_id;


    private String imgName; // 상품명

    private String oriImgFileName; // 원본이미지파일명

    private String imgUrl; // 업데이트할 이미지 파일 경로

    private String repImgYn; //대표 사진 설정

    @Builder
    public ItemImgDto (Long item_img_id, String oriImgFileName, String imgUrl) {
        this.item_img_id = item_img_id;
        this.oriImgFileName = oriImgFileName;
        this.imgUrl =imgUrl;
    }

    public ItemImgDto of(ItemImg itemImg) {
        ItemImgDto itemImgDto = ItemImgDto.builder()
                .item_img_id(itemImg.getItem_img_id())
                .imgUrl(itemImg.getImgUrl())
                .oriImgFileName(itemImg.getOriImgFileName())
                .build();

        return itemImgDto;
    }


}
