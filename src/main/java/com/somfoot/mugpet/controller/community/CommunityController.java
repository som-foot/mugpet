package com.somfoot.mugpet.controller.community;

import com.somfoot.mugpet.dto.CommunityDto;
import com.somfoot.mugpet.entity.Community;
import com.somfoot.mugpet.entity.Reply;
import com.somfoot.mugpet.service.community.CommunityService;
import com.somfoot.mugpet.service.community.ReplyService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@NoArgsConstructor
public class CommunityController {
    @Autowired
    private CommunityService communityService;
    @Autowired
    private ReplyService replyService;
    
    //멤버서비스도 추가하기

    //게시글 목록 페이지에서 작성 버튼 클릭 시 이동하도록
    @GetMapping(value = "/community/communityList/insert")
    public String insertCom(Model model){
        //command로 변경해야할듯
        model.addAttribute("CommunityForm", new CommunityDto());

        //communityForm으로 이동
        return "community/communityForm";
    }

    //command로 변경
    @PostMapping(value = "/community/communityList/insert")
    public String insertCom(@Valid @RequestPart CommunityDto communityDto, Model model,
                            @RequestPart("communityImgFile") List<MultipartFile> communityImgFileList, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //오류 존재 시 작성 폼으로 이동
            return "community/communityForm";
        }

        //넘겨주는 구문 추가하기

        //게시글 상세페이지로 이동
       return "redirect:/community/detail";
    }

    //command 추가 후 매끄럽게 수정하기
    @GetMapping(value = "/community/{com_id}")
    public String viewCom(@PathVariable("com_id") Long com_id, Model model) throws Exception {
        Community community = null;
        community = communityService.findCom(com_id);

        List<Reply> replyList = replyService.findAllByCom_Id(com_id);
        ArrayList<String> rp_nicknameList = new ArrayList<String>();

        long u_id = communityService.findU_IdByCom_Id(com_id);
        //String nickname = 멤버서비스에서 u_id로 nickname 찾기

        for (Reply reply : replyList) {
            //long rp_id = reply.getRp_Id();
            //long rp_u_id = replyService.findU_IdByComReply(com_id, rp_id);
            //String rp_nickname = 멤버서비스에서 u_id로 nickname 찾기
            //rp_nicknameList.add(rp_nickname);
        }

        model.addAttribute("community", community);
        model.addAttribute("replyList", replyList);
        //model.addAttribute("nickname", nickname);
        //model.addAttribute("rp_nicknameList", rp_nicknameList);

        return "community/detail";
    }

    @GetMapping(value = "/community/{com_id}/update")
    public String updateComForm(@PathVariable("com_id") Long com_id, Model model) throws Exception{
        //command로
        Community community = null;
        community = communityService.findCom(com_id);

        model.addAttribute("community", community);

        return "community/update";
    }

    @PostMapping(value = "/community/{com_id}/update")
    public String updateCom(Community community, RedirectAttributes redirectAttributes) throws Exception{
        //수정 내용 넘겨주기

        return "redirect:/community/{com_id}";
    }
}
