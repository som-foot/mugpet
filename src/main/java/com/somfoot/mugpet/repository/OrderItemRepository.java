package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
