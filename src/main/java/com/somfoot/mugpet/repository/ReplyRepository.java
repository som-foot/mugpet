package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    //insert
    //update
    //delete
    //find
    //findAll
}
