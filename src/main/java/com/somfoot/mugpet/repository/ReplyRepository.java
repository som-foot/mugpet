package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    //insert
    //insertComReply
    //insertGoodsReply

    //update
    //댓글 수정 기능 추가하기
    
    //delete
    @Query("delete from Reply where rp_id = :rp_id and com_id = :com_id")
    void deleteReplyByCom_Id(long rp_id, long com_id);

    @Query("delete from Reply where rp_id = :rp_id and g_id = :g_id")
    void deleteReplyByG_Id(long rp_id, long g_id);

    @Query("delete from Reply where com_id = :com_id")
    void deleteAllByCom_Id(long com_id);

    @Query("delete from Reply where g_id = :g_id")
    void deleteAllByG_Id(long g_id);
    //find
    @Query("select u_id form Reply where com_id = :com_id and rp_id = :rp_id")
    long fidU_IdByComReply(long com_id, long rp_id);

    @Query("select u_id from Reply where g_id = :g_id and rp_id = :rp_id")
    long findU_IdByGoodsReply(long g_id, long rp_id);
    //findAll
    @Query("select rp_id, content, enrollDt, u_id, com_id"
        + "from Reply where com_id = :com_id order by enrollDt desc")
    List<Reply> findAllByCom_Id(long com_id);
    @Query("select rp_id, content, enrollDt, u_id, g_id"
            + "from Reply where g_id = :g_id order by enrollDt desc")
    List<Reply> findAllByG_Id(long g_id);

    @Query("select * from Reply where u_id = :u_id order by enrollDt desc")
    List<Reply> findAllByU_Id(long u_id);
}
