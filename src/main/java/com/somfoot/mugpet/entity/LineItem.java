package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="LineItem")
@Getter
@IdClass(LineItemPK.class)
//하나의 주문에서 각각의 아이템
public class LineItem implements Serializable {

    @Id
    private long o_id;      //PK_주문번호
    @Id
    private long line;      //PK_하나의 주문에서의 행 번호
    private int quantity;   //개수
    private int price;      //가격

    //1:1 연관관계
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "item_id")
    private Item item;      //해당 item

    public LineItem() {}

    @Builder(builderMethodName = "lineItemBuilder")
    public LineItem(long o_id, long line, long item_id) {
        this.o_id = o_id;
        this.line = line;
    }
}
