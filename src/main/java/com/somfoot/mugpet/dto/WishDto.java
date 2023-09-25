package com.somfoot.mugpet.dto;

import com.somfoot.mugpet.entity.Item;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishDto {

    private Item item;	//wish에 들어간 item_id
    private long u_id;		//wish에 넣은 u_id
}
