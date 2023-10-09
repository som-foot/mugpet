package com.somfoot.mugpet.service.usedGoods;

import com.somfoot.mugpet.entity.UsedGoods;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UsedGoodsService {
    public List<UsedGoods> findAllGoods();

    public List<UsedGoods> findAllById(long u_id);

    public UsedGoods findGoods(long g_id);

    public long findU_IdByG_Id(long g_id);

    //command 만들기
    public void insertUsedGoods(UsedGoods goodsCommand, MultipartFile file) throws Exception;

    public void insertUsedGoodsWithoutImgFile(UsedGoods goodsCommand);

    //command 만들기
    public void updateUsedGoods(UsedGoods goodsCommand, MultipartFile file) throws Exception;

    public void updateUsedGoodsWithoutImgFile(UsedGoods goodsCommand);

    public void deleteById(long g_id);

    public void updateGoodsLikesCnt(int amount, long g_id);
}
