package com.somfoot.mugpet.controller.usedGoods;

import com.somfoot.mugpet.dto.UsedGoodsDto;
import com.somfoot.mugpet.entity.UsedGoods;
import com.somfoot.mugpet.service.usedGoods.UsedGoodsService;
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
public class UsedGoodsController {
    private UsedGoodsService usedGoodsService;

    //게시글 목록 페이지에서 작성 버튼 클릭 시 이동하도록
    @GetMapping(value = "/usedgoods/usedgoodsList/insert")
    public String insertGoods(Model model){
        //command로 변경해야할듯
        model.addAttribute("UsedGoodsForm", new UsedGoodsDto());

        //uedGoodsForm으로 이동
        return "usedgoods/usedgoodsForm";
    }

    //command로 변경
    @PostMapping(value = "/usedgoods/usedgoodsList/insert")
    public String insertGoods(@Valid @RequestPart UsedGoodsDto usedGoodsDto, Model model,
                              @RequestPart("usedgoodsImgFile") List<MultipartFile> communityImgFileList, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //오류 존재 시 작성 폼으로 이동
            return "usedgoods/usedgoodsForm";
        }

        //넘겨주는 구문 추가하기

        //게시글 상세페이지로 이동
        return "redirect:/usedgoods/detail";
    }

    //command 추가 후 매끄럽게 수정하기
    @GetMapping(value = "/usedgoods/{g_id}")
    public String viewGoods(@PathVariable("g_id") Long g_id, Model model) throws Exception {
        UsedGoods usedGoods = null;
        usedGoods = usedGoodsService.findGoods(g_id);

        long u_id = usedGoodsService.findU_IdByG_Id(g_id);

        model.addAttribute("usedgoods", usedGoods);

        return "usedgoods/detail";
    }

    @GetMapping(value = "/usedgoods/{g_id}/update")
    public String updateGoodsForm(@PathVariable("g_id") Long g_id, Model model) throws Exception{
        //command로
        UsedGoods usedGoods = null;
        usedGoods = usedGoodsService.findGoods(g_id);

        model.addAttribute("usedgoods", usedGoods);

        return "usedgoods/update";
    }

    @PostMapping(value = "/usedgoods/{g_id}/update")
    public String updateGoods(UsedGoods usedGoods, RedirectAttributes redirectAttributes) throws Exception{
        //수정 내용 넘겨주기

        return "redirect:/usedgoods/{g_id}";
    }
}
