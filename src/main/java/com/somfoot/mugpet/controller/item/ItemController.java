package com.somfoot.mugpet.controller.item;


import com.somfoot.mugpet.dto.ItemFormDto;
import com.somfoot.mugpet.entity.Item;
import com.somfoot.mugpet.service.item.ItemImgService;
import com.somfoot.mugpet.service.item.ItemService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@NoArgsConstructor
public class ItemController {

    private ItemService itemService;
    private ItemImgService itemImgService;


    @GetMapping(value = "/admin/item/new")
    public String newItem(Model model) {
        model.addAttribute("itemFromDto",new ItemFormDto());

        return "item/itemForm";
    }

    @PostMapping(value = "/admin/item/new")
    public String newItem (@Valid @RequestPart ItemFormDto itemFormDto, Model model,
                           @RequestPart("itemImgFile") List<MultipartFile> itemImgFileList, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "item/itemForm";
        }

        if(itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null) {
            model.addAttribute("errorMessage","첫번째 상품 이미지는 필수입니다.");
            return "item/itemForm";
        }

        try {
            itemService.savedItem(itemFormDto.toEntity(itemFormDto),itemImgFileList);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/";
    }



    //아이템 상세보기
    @GetMapping(value = "/admin/items/{itemId}")
    public String itemDtl (@PathVariable("itemId") Long itemId,Model model) throws Exception {

       ItemFormDto itemDto = new ItemFormDto().of(itemService.findById(itemId));

       model.addAttribute("itemDto",itemDto);

        return "admin/item/itemDtl";
    }

    //아이템 수정하기
    @GetMapping(value = "/admin/items/{itemId}/edit")
    public String modifyItemform (@PathVariable("itemId") Long itemId,Model model) throws Exception {

        ItemFormDto itemDto = new ItemFormDto().of(itemService.findById(itemId));

        model.addAttribute("itemDto",itemDto);

        return "admin/item/edit";
    }

    @PostMapping(value = "/admin/items/{itemId}/edit")
    public String modifyItem (ItemFormDto itemFormDto, RedirectAttributes redirectAttributes) throws Exception {

        Item item = itemService.findById(itemFormDto.getId());


        itemService.updateItemForm(itemFormDto);
        item.updateItem(itemFormDto);

        redirectAttributes.addAttribute(itemFormDto.getId());

        return "redirect: /admin/items/{itemId}";
    }







}
