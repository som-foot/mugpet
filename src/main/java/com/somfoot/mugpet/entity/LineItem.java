package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="LineItem")
@Getter
@IdClass(LineItemPK.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//하나의 주문에서 각각의 아이템
public class LineItem implements Serializable {

    @Id
    private long o_id;      //PK_주문번호
    @Id
    private long line;      //PK_하나의 주문에서의 행 번호
    private int lineQty;    //개수
    private int linePrice;      //가격

    //1:1 연관관계
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "item_id")
    private Item item;      //해당 item

    //N:1 양방향 연관관계
    @ManyToOne
    @JoinColumn(name = "u_id") //FK
//    private Users user;
    private MemberInfo member;  //주문한 user

    @Builder(builderMethodName = "lineItemBuilder")
    public LineItem(long o_id, long line, long item_id) {
        this.o_id = o_id;
        this.line = line;
    }
}
