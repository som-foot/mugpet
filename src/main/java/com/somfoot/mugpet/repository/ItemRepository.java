package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.Item;
import com.somfoot.mugpet.entity.ItemImg;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface ItemRepository extends JpaRepository<Item,Long> {

    //item 정렬
    List<Item> findBySpe_idOrderByStandASCOdASC(int spe_id);

    //item 정렬(카테고리별 페이지에서)
    List<Item> findBySpe_idAndCategory_idOrderByStandASCOdASC(int spe_id, int category_id);

    //둘 중 뭘로?
    //item 필터링
    List<Item> filteringItemList(Map<String, Object> param);
    List<Item> filteringItemList2(Map<String, Object> param);

    //필터링 결과 정렬
    List<Item> orderByFiltering(Map<String, Object> param);
}
