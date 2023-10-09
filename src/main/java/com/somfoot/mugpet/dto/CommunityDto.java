package com.somfoot.mugpet.dto;

import com.somfoot.mugpet.entity.Community;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityDto {
    private long com_id;					//primary key
    private String imageUrl;			//이미지 경로
    @NotEmpty(message = "제목은 필수 입력 값입니다.")
    private String title;				//제목
    @NotEmpty(message = "내용운 필수 입력 값입니다.")
    private String content;				//내용
    private Date enrollDt;				//작성시간
    private int likes;					//좋아요 수
    private int replyCnt;				//댓글 수
    private long u_id;					//작성자 id

    //entity로 리턴해줄 메소드
  /*  public Community toEntity(CommunityDto communityDto){
        Community com = Community.builder()
                .com_id(communityDto.com_id)
                .imageUrl(communityDto.imageUrl)
                .title(communityDto.title)
                .content(communityDto.content)
                .enrollDt(communityDto.enrollDt)
                .likes(communityDto.likes)
                .replyCnt(communityDto.replyCnt)
                .u_id(communityDto.u_id)
                .build();

        return com;
    }
*/
    //entity를 dto로 리턴해줄 메소드
}
