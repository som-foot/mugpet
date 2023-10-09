package com.somfoot.mugpet.dto;

import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "내용은 필수 입력 값입니다.")
    private String content;		//댓글 내용
    private Date enrollDt;		//작성 시간
    private long u_id;			//작성자 id
    private long com_id;			//댓글 단 커뮤니티 글 id
}
