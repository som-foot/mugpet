package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.Filter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilterRepository extends JpaRepository<Filter,Long> {

    //insert -> item추가시 함께 추가(작성폼 만들 것)
    //update -> item수정시 함께 수정(작성폼 사용)
    //delete -> item삭제하면 함께 삭제
}
