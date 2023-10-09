package com.somfoot.mugpet.service.community;

import com.somfoot.mugpet.entity.Community;
import com.somfoot.mugpet.repository.CommunityRepository;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService{
    @Autowired
    private CommunityRepository communityRepository;

    @Override
    public List<Community> findAllCom() {
        return communityRepository.findAll();
    }

    @Override
    public List<Community> findAllById(long u_id) {
        return communityRepository.findAllById(u_id);
    }

    @Override
    public Community findCom(long com_id) {
        return communityRepository.findById(com_id);
    }

    @Override
    public long findU_IdByCom_Id(long com_id) {
        return communityRepository.findU_IdByComId(com_id);
    }

    @Override
    public void insertCom(Community comCommand, MultipartFile file) throws Exception {
    //insert 이미지포함
    }

    @Override
    public void insertComWithoutImgFile(Community comCommand) {
    //insert 이미지제외
    }

    @Override
    public void updateCom(Community comCommand, MultipartFile file) throws Exception {
    //update 이미지포함
    }

    @Override
    public void updateComWithoutImgFile(Community comCommand) {
    //update 이미지제외
    }

    @Override
    public void deleteCom(long com_id) {
        communityRepository.deleteById(com_id);
    }

    @Override
    public void updateComLikesCnt(int amount, long com_id) {
        communityRepository.updateComLikesCnt(amount, com_id);
    }
}
