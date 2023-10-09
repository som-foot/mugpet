package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.Item;
import com.somfoot.mugpet.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    //주문과 동시에 LineItem에서도 삽입발생해야함
    //주문취소와 동시에 LineItem에서도 삭제발생해야함

    //주문목록(최신순) -> 필드에 List<LineItem>이 있으면 가져올 수 있는가..?
    List<Orders> findByU_idOrderByOrderDateDescOrderTimeDesc(long u_id);

    //주문목록(오래된순)
    List<Orders> findByU_idOrderByOrderDateAscrderTimeAsc(long u_id);

    //주문한 상품 정보
    Optional<Item> findById(long o_id);
}
