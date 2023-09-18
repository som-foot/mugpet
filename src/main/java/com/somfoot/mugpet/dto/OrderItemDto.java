package com.somfoot.mugpet.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderItemDto {
    @Id
    @Column(name = "o_id")
    private long id;				//primary key(o_id)
    //private int o_id;				//primary key
    private int orderQty;			//구매하는 개수
    private String orderAddr;		//배송지
    private String orderPhoneNum; 	//전화번호
    private int item_id;			//구매한 item의 id
    private int itemPrice;			//구매한 아이템 당 개수를 고려한 가격
    private int applyPoints;		//적용한 적립금
    private String req;				//사용자 요청사항
    private String orderTime;		//주문한 시간
    private int u_id;				//로그인한 사용자 id
}
