package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="item_img")
public class ImgFile {

	@Id
	@Column(name="item_img_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String imgName; //상품명

	private String oriImgFileName; //원본이미지파일명

	private String imgUrl; //업데이트할 이미지 파일명

	private String repImgYn; //대표 사진 설정

	//원본 이미지 파일명, 업데이트할 이미지 파일명, 이미지 경로를 파라미터로 받아서 이미지 정보를 업데이트
	public void updateItemImg(String oriImgName, String imgName, String imgUrl) {

		this.oriImgFileName = oriImgFileName;
		this.imgName = imgName;
		this.imgUrl = imgUrl;
	}



	

	
}
