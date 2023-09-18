package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.UsedGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsedGoodsRepository extends JpaRepository<UsedGoods, Long> {
    //insert
    //update
    //delete
    //find
    //findAll
}
