package com.somfoot.mugpet.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cartItem")
@Getter
@Setter
public class CartItem { //Cart에 담긴 item 하나하나를 의미
    @Id
    @Column(name="cartItem_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;		        //primary key(cartId)

    @OneToOne(mappedBy = "Item")
    @JoinColumn(name="item_id")
    private Item item;              //item 정보
    private int quantity;	        //개수

    @ManyToOne
    @JoinColumn(name="u_id")
    private MemberInfo memberInfo;  //로그인한 사용자 id -> session으로 처리? member_id에 따른 cartItem 정보를 가지고 오려면 필요하지 않은지

    public CartItem() {}

    @Builder
    public CartItem(long id, Item item, int quantity, MemberInfo memberInfo){
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.memberInfo = memberInfo;
    }

    public int getTotalPrice(){ //item의 단가 * quantity
        if(item != null)
            return item.getPrice() * quantity;
        else
            return 0;
    }

    public void incrementQuantity(){
        quantity++;
    }
}
