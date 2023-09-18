package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
    //insert
    //update
    //delete
    //find
    //findAll
}
