package com.somfoot.mugpet.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsedGoodsDto {
    private long g_id;				//primary key
    private String imageUrl;			//이미지 경로
    @NotEmpty(message = "제목은 필수 입력 값입니다.")
    private String title;			//제목
    @NotEmpty(message = "내용은 필수 입력 값입니다.")
    private String content;			//내용
    private Date enrollDt;			//작성시간
    private int price;				//가격
    private int likes;				//좋아요 수
    private long u_id;				//작성자 id
}
