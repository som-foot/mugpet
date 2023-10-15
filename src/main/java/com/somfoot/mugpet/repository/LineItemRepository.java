package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemRepository extends JpaRepository<LineItem, Long> {

    //LineItem삽입, 삭제

    //주문한 item

}
