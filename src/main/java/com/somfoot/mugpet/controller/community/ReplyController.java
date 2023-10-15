package com.somfoot.mugpet.controller.community;

import com.somfoot.mugpet.service.community.CommunityService;
import com.somfoot.mugpet.service.community.ReplyService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@NoArgsConstructor
public class ReplyController {
    private ReplyService replyService;

    private CommunityService communityService;

    //멤버서비스 추가
}
