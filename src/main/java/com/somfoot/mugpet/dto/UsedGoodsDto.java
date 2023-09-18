package com.somfoot.mugpet.dto;


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
    private String title;			//제목
    private String content;			//내용
    private Date enrollDt;			//작성시간
    private int price;				//가격
    private int likes;				//좋아요 수
    private int replyCnt;			//댓글 수
    private int u_id;				//작성자 id
}
