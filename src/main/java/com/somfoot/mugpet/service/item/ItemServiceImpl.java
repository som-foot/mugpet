package com.somfoot.mugpet.service.item;

import com.somfoot.mugpet.dto.ItemFormDto;
import com.somfoot.mugpet.dto.ItemImgDto;
import com.somfoot.mugpet.entity.Item;
import com.somfoot.mugpet.entity.ItemImg;
import com.somfoot.mugpet.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
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

        return item.getItem_id();
    }

    @Override
    public Item findById(Long itemId) throws Exception {

        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new NoSuchElementException("Item Not Found"));

        return item;
    }

    @Override
    public Long updateItemForm(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws Exception {
        //상품 수정
        Item item = itemRepository.findById(itemFormDto.getId())
                .orElseThrow(EntityNotFoundException::new);
        item.updateItem(itemFormDto);

        List<ItemImgDto> itemImgDtos = itemFormDto.getItemImgDtos();

        //이미지 등록
        //더티체킹
        for(int i=0; i<itemImgDtos.size();i++) {
            itemImgService.updateItemImg(itemImgDtos.get(i).getItem_img_id()
                    ,itemImgFileList.get(i));
        }
        return item.getItem_id();



    }
}
