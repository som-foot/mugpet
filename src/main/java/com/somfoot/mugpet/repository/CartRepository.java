package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
