package com.somfoot.mugpet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto {
    private long rp_id;			//primary key
    private String content;		//댓글 내용
    private Date enrollDt;		//작성 시간
    private int u_id;			//작성자 id
    private int com_id;			//댓글 단 커뮤니티 글 id
    private int g_id;			//댓글 단 중고거래 글 id
}
