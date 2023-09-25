package com.somfoot.mugpet.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;  //도로명주소
    private String detail;  //상세주소

}
