package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.UsedGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsedGoodsRepository extends JpaRepository<UsedGoods, Long> {
    //insert
    //update
    @Query("update UsedGoods " +
            "set imageUrl = :goods.imageUrl, title = :goods.title, content = :goods.content, enrollDt = SYSDATE, likes = :goods.likes, replyCnt = :goods.replyCnt, u_id = :goods.u_id" +
            "where g_id = :goods.g_id")
    UsedGoods updateCom(UsedGoods goods);

    @Query("update UsedGoods set replyCnt = replyCnt + :amount where g_id = :g_id")
    int updateReplyCnt(int amount, long g_id);

    @Query("update UsedGoods set likes = likes + :amount where g_id = :g_id")
    int updateGoodsLikesCnt(int amount, long g_id);
    //delete
    void deleteById(long g_id);

    //find
    UsedGoods findById(long g_id);

    @Query("select u_id from UsedGoods where g_id = :g_id")
    long findU_IdByGId(long g_id);

    //findAll
    //List<UsedGoods> findAll();
    List<UsedGoods> findAllById(long u_id);
}
