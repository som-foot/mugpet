package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "usedGoods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsedGoods {

	@Id
	@Column(name = "g_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long g_id;				//primary key
	private String imageUrl;			//이미지 경로

	@NonNull
	private String title;			//제목
	@NonNull
	private String content;			//내용
	private Date enrollDt;			//작성시간
	@NonNull
	private int price;				//가격
	private int likes;				//좋아요 수
	private int replyCnt;			//댓글 수
	private int u_id;				//작성자 id
}
