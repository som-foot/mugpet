package com.somfoot.mugpet.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pet")
@Getter @Setter
public class Pet {

	@Id
	@Column(name = "pet_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;			//primary key
	private String name;		//반려동물 이름
	private int spe_id;			//반려동물 종(강아지 or 고양이 or 소동물)
	private String birth;		//반려동물 생일


	// DB 에서 pet (다) 쪽이 외래키 갖음
	// member 쪽에서는 pet 참조 안 함.
	@ManyToOne
	@JoinColumn(name = "member_id")
	private MemberInfo memberInfo;

	public Pet() {}


	@Builder
	public Pet(long id, String name, int spe_id, String birth,MemberInfo memberInfo) {
		this.id = id;
		this.name = name;
		this.spe_id = spe_id;
		this.birth = birth;
		this.memberInfo = memberInfo;
	}
}