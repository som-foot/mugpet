package com.somfoot.mugpet.service.usedGoods;

import com.somfoot.mugpet.entity.UsedGoods;
import com.somfoot.mugpet.repository.UsedGoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UsedGoodsServiceImpl implements UsedGoodsService{
    @Autowired
    private UsedGoodsRepository usedGoodsRepository;

    @Override
    public List<UsedGoods> findAllGoods() {
        return usedGoodsRepository.findAll();
    }

    @Override
    public List<UsedGoods> findAllById(long u_id) {
        return usedGoodsRepository.findAllById(u_id);
    }

    @Override
    public UsedGoods findGoods(long g_id) {
        return usedGoodsRepository.findById(g_id);
    }

    @Override
    public long findU_IdByG_Id(long g_id) {
        return usedGoodsRepository.findU_IdByGId(g_id);
    }

    @Override
    public void insertUsedGoods(UsedGoods goodsCommand, MultipartFile file) throws Exception {
    //insert 이미지포함
    }

    @Override
    public void insertUsedGoodsWithoutImgFile(UsedGoods goodsCommand) {
    //insert 이미지제외
    }

    @Override
    public void updateUsedGoods(UsedGoods goodsCommand, MultipartFile file) throws Exception {
    //update 이미지포함
    }

    @Override
    public void updateUsedGoodsWithoutImgFile(UsedGoods goodsCommand) {
    //update 이미지제외
    }

    @Override
    public void deleteById(long g_id) {
        usedGoodsRepository.deleteById(g_id);
    }

    @Override
    public void updateGoodsLikesCnt(int amount, long g_id) {
        usedGoodsRepository.updateGoodsLikesCnt(amount, g_id);
    }
}
