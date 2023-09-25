package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="wish")
@Getter
@Setter
public class Wish {

	@PrimaryKeyJoinColumn(name="item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;		//primary key

	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;		//wish에 들어간 item_id

	@ManyToOne
	@JoinColumn(name="u_id")
	private MemberInfo memberInfo; 	//wish에 넣은 u_id
	
	public Wish() {}

	public Wish(long id, Item item, MemberInfo memberInfo) {
		this.id = id;
		this.item = item;
		this.memberInfo = memberInfo;
	}
}
