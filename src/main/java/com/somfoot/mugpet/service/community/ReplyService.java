package com.somfoot.mugpet.service.community;

import com.somfoot.mugpet.entity.Reply;

import java.util.List;

public interface ReplyService {
    public List<Reply> findAllByCom_Id(long com_id);

    public List<Reply> findAllByU_Id(long u_id);

    public long findU_IdByComReply(long com_id, long rp_id);

    //command 만들기
    public void insertReply(Reply replyCommand);

    //command 만들기
    public void updateReply(Reply replyCommand);

    public void deleteReplyByCom_Id(long rp_id, long com_id);

    public void deleteAllByCom_Id(long com_id);
}