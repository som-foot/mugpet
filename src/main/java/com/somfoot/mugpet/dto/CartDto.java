package com.somfoot.mugpet.dto;

import com.somfoot.mugpet.entity.Item;
import com.somfoot.mugpet.entity.MemberInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartDto {

    private Item item;                  //item 정보
    private int quantity;	            //개수
    private MemberInfo memberInfo;      //로그인한 사용자 id

}
