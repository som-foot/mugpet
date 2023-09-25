package com.somfoot.mugpet.service.item;

import com.somfoot.mugpet.dto.ItemFormDto;
import com.somfoot.mugpet.entity.Item;
import com.somfoot.mugpet.repository.ItemRepository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {

    Long savedItem(Item item, List<MultipartFile> ImgFileList) throws Exception;
    Item findById(Long itemId) throws Exception;

   // void updateItemForm(Item item,List<MultipartFile> ImgFileList) throws Exception;

    void updateItemForm(ItemFormDto itemFormDto);
}
