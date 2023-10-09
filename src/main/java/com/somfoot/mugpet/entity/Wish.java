package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Wish")
@Getter
@Setter
public class Wish {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long w_id;		//primary key

	@OneToOne
	@JoinColumn(name="item_id")
	private Item item;		//wish에 들어간 item_id

	@ManyToOne
	@JoinColumn(name="u_id")
	private MemberInfo memberInfo; 	//wish에 넣은 u_id
	
	public Wish() {}

	public Wish(long w_id, Item item, MemberInfo memberInfo) {
		this.w_id = w_id;
		this.item = item;
		this.memberInfo = memberInfo;
	}
}
