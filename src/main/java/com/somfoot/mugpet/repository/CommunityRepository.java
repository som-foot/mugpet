package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
    //insert
    //update
    @Query("update Community " +
            "set imageUrl = :com.imageUrl, title = :com.title, content = :com.content, enrollDt = SYSDATE, likes = :com.likes, replyCnt = :com.replyCnt, u_id = :com.u_id" +
            "where com_id = :com.com_id")
    Community updateCom(Community com);

    @Query("update Community set replyCnt = replyCnt + :amount where com_id = :com_id")
    int updateReplyCnt(int amount, long com_id);

    @Query("update Community set likes = likes + :amount where com_id = :com_id")
    int updateComLikesCnt(int amount, long com_id);
    //delete
    void deleteById(long com_id);

    //find
    Community findById(long com_id);

    @Query("select u_id from Community where com_id = :com_id")
    long findU_IdByComId(long com_id);

    //findAll
    //List<Community> findAll();
    List<Community> findAllById(long u_id);
}
