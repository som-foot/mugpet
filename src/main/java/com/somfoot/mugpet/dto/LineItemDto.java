package com.somfoot.mugpet.dto;

import com.somfoot.mugpet.entity.Item;
import com.somfoot.mugpet.entity.MemberInfo;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
public class LineItemDto {

    private long o_id;      //PK_주문번호
    private long line;      //PK_하나의 주문에서의 행 번호
    private int lineQty;    //개수
    private int linePrice;      //가격

    //객체참조는 dto에서 어떻게..?
    private Item item;      //해당 item
    private MemberInfo member;  //주문한 user
}
