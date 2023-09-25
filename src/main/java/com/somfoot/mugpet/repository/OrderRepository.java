package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    //주문목록, 주문한 상품 정보, 총 주문한 상품 개수, 주문, 주문 취소
}
