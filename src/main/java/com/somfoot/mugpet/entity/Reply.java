package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "reply")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reply {

	@Id
	@Column(name = "rp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long rp_id;			//primary key

	@NonNull
	private String content;		//댓글 내용
	private Date enrollDt;		//작성 시간
	private int u_id;			//작성자 id
	private int com_id;			//댓글 단 커뮤니티 글 id
	private int g_id;			//댓글 단 중고거래 글 id
}
