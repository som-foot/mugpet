package com.somfoot.mugpet.service.community;

import com.somfoot.mugpet.entity.Community;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CommunityService {
    public List<Community> findAllCom();

    public List<Community> findAllById(long u_id);

    public Community findCom(long com_id);

    public long findU_IdByCom_Id(long com_id);

    //command 역할 클래스 생성해야할 듯
    public void insertCom(Community comCommand, MultipartFile file) throws Exception;

    public void insertComWithoutImgFile(Community comCommand);

    //command 역할 클래스 생성해야할 듯
    public void updateCom(Community comCommand, MultipartFile file) throws Exception;

    public void updateComWithoutImgFile(Community comCommand);

    public void deleteCom(long com_id);

    public void updateComLikesCnt(int amount, long com_id);
}
