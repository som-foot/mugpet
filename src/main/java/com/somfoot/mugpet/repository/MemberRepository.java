package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberInfo,Integer> {
}
