package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.Item;
import com.somfoot.mugpet.entity.ItemImg;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ItemRepository extends JpaRepository<Item,Long> {

    //item 한 개
    Optional<Item> findById(long item_id);

    //item 목록
    List<Item> findAll();

    //item 목록(카테고리별)
    List<Item> findByCategory(int category);

    //item 정렬(메인에서 정렬)
    List<Item> findBySpecies(int species, Sort sort);

    //item 정렬(카테고리별 페이지에서)
    List<Item> findBySpeciesAndCategory(int species, int category, Sort sort);

    //item 필터링
    //mybatis로...?

    //item 필터링 결과 정렬

}
