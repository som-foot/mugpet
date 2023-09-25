package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Orders")
@Getter @Setter
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long o_id;          //PK
    private int orderQty;       //구매하는 item종류 개수

    //필요할지..? n:1양방향?
    //onetomany로 객체참조
    private long u_id;          //로그인한 사용자 id

    @Embedded
    private Address address;    //주소

    private String phone;       //전화번호
    private int totalPrice;     //총 가격
    private int usingPoint;     //사용된 포인트
    private int payment;        //결제금액
    private String userReq;     //고객 요청사항

    @Temporal(TemporalType.DATE)
    private Date orderDate;     //주문 날짜

    @Temporal(TemporalType.TIME)
    private Date orderTime;     //주문 시간

    //주문상품 리스트
    //1:N 연관관계
    @OneToMany
    @JoinColumn(name = "o_id") //FK
    private List<LineItem> lineItemList;

    public Order() {}

    @Builder(builderMethodName = "orderBuilder")

    public Order(long o_id, long u_id, List<LineItem> lineItemList) {
        this.o_id = o_id;
        this.u_id = u_id;
        this.lineItemList = lineItemList;
    }
}
