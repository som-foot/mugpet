package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long o_id;          //PK
    private int orderQty;       //구매하는 item종류 개수
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

    //N:1 양방향 연관관계
    @ManyToOne
    @JoinColumn(name = "u_id") //FK
//    private Users user;
    private MemberInfo member;  //주문한 user

    @Builder(builderMethodName = "orderBuilder")

    public Orders(long o_id, List<LineItem> lineItemList) {
        this.o_id = o_id;
        this.lineItemList = lineItemList;
    }
}
