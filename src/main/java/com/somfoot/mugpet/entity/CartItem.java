package com.somfoot.mugpet.entity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CartItem")
@Getter
@Setter
public class CartItem { //Cart에 담긴 item 하나하나를 의미
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartItem_id;		        //primary key(cartItem_id)

    @OneToOne(targetEntity = Item.class)
    @JoinColumn(name="item_id")     //상대 테이블을 참조하기 위한 FK컬럼명 지정
    private Item item;              //item 정보

    private int quantity;	        //개수

    @ManyToOne
    @JoinColumn(name="u_id")
    private MemberInfo memberInfo;  //로그인한 사용자 id -> session으로 처리? member_id에 따른 cartItem 정보를 가지고 오려면 필요하지 않은지

    public CartItem() {}

    @Builder
    public CartItem(long cartItem_id, Item item, int quantity, MemberInfo memberInfo){
        this.cartItem_id = cartItem_id;
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
