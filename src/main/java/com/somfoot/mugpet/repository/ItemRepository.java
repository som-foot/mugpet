package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {


}
