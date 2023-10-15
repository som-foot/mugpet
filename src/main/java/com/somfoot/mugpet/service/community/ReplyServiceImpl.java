package com.somfoot.mugpet.service.community;

import com.somfoot.mugpet.entity.Reply;
import com.somfoot.mugpet.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
    @Autowired
    private ReplyRepository replyRepository;

    @Override
    public List<Reply> findAllByCom_Id(long com_id) {
        return replyRepository.findAllByCom_Id(com_id);
    }

    @Override
    public List<Reply> findAllByU_Id(long u_id) {
        return replyRepository.findAllByU_Id(u_id);
    }

    @Override
    public long findU_IdByComReply(long com_id, long rp_id) {
        return replyRepository.findU_IdByComReply(com_id, rp_id);
    }

    @Override
    public void insertReply(Reply replyCommand) {
    //댓글 추가
    }

    @Override
    public void updateReply(Reply replyCommand) {
    //댓글 수정
    }

    @Override
    public void deleteReplyByCom_Id(long rp_id, long com_id) {
        replyRepository.deleteReplyByCom_Id(rp_id, com_id);
    }

    @Override
    public void deleteAllByCom_Id(long com_id) {
        replyRepository.deleteAllByCom_Id(com_id);
    }
}
