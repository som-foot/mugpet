package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="FILTER")
@Getter @Setter
public class Filter implements Serializable {

	@Id
	@Column(name = "item_id")
	private long item_id;		//primary key & foreign key
	private int age;			//연령
	private String stuff;		//주원료
	private String feature;		//기능

	//1:1 양방향 연관관계
	@OneToOne(mappedBy = "filter", optional = false)
	private Item item;
	
	public Filter() {}

	@Builder(builderMethodName = "filterBuilder")
	public Filter(int item_id, int age, String stuff, String feature) {
		this.item_id = item_id;
		this.age = age;
		this.stuff = stuff;
		this.feature = feature;
	}
}
