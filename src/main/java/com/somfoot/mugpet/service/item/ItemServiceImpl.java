package com.somfoot.mugpet.service.item;

import com.somfoot.mugpet.dto.ItemFormDto;
import com.somfoot.mugpet.entity.Item;
import com.somfoot.mugpet.entity.ItemImg;
import com.somfoot.mugpet.repository.ItemImgRepository;
import com.somfoot.mugpet.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private ItemRepository itemRepository;

    private ItemImgService itemImgService;

    @Override
    public Long savedItem(Item item, List<MultipartFile> itemImgFileList) throws Exception {

        itemRepository.save(item);

        for (int i = 0; i < itemImgFileList.size(); i++) {
            ItemImg itemImg = new ItemImg();
            itemImg.setItem(item);

            if(i==0)
                itemImg.setRepImgYn("y");
            else
                itemImg.setRepImgYn("n");


            itemImgService.savedItemImg(itemImg,itemImgFileList.get(i));

        }

        return item.getId();
    }

    @Override
    public Item findById(Long itemId) throws Exception {

        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new NoSuchElementException("Item Not Found"));

        return item;
    }

    @Override
    public void updateItemForm(Item item, List<MultipartFile> ImgFileList) throws Exception {

    }
}
