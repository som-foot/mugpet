package com.somfoot.mugpet.entity;

import com.somfoot.mugpet.dto.MemberFormDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter @Setter
@NoArgsConstructor
public class MemberInfo {

	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;            	//primary key(userId)

	private String nickname;    	//닉네임
	private String name;        	//이름
	@Column(unique = true)
	private String email;        	//이메일(로그인할 아이디)
	private String password;            	//비밀번호
	private String phoneNum;    	//전화번호
	private String address;        	//주소
	private int point;            	//적립포인트

	//일대다 양방향
	@OneToMany(mappedBy = "member")
	private List<Pet> pets = new ArrayList<>();
	private String role;

	//N:1 양방향 연관관계
	@OneToMany(mappedBy = "LineItem")
	private List<LineItem> lineItemList;

	//N:1 양방향 연관관계
	@OneToMany(mappedBy = "Orders")
	private List<LineItem> orderList;

	@Builder
	public MemberInfo (long id,String nickname,String name,String email, String password, String phoneNum,String address,int point,String role){
		this.id = id;
		this.nickname = nickname;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;
		this.address = address;
		this.point = point;
		this.role = role;
	}

}