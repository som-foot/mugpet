package com.somfoot.mugpet.service.item;

import com.somfoot.mugpet.entity.ItemImg;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemImgService {


    void savedItemImg(ItemImg itemImg, MultipartFile itemImgFile) throws Exception;
    void updateItemImg(Long itemImgId, MultipartFile itemImgFile) throws Exception;
}
