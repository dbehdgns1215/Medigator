package com.medigator.medigator.controller;

import com.medigator.medigator.dto.MyPageDTO;
import com.medigator.medigator.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MyPageController {
    // 생성자 주입
    private final MyPageService mypageService;

    @GetMapping("/member/MyPage")
    public String MyPageForm() {
        return "MyPage";
    }

    @PostMapping("/member/MyPage")
    public String MyPage(@ModelAttribute MyPageDTO mypageDTO) {
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + mypageDTO);
        mypageService.MyPage(mypageDTO);
        return "MyPage";
    }
}
