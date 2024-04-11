package com.medigator.medigator.controller;

import com.medigator.medigator.dto.MemberDTO;
import com.medigator.medigator.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class MemberController {
    // 생성자 주입
    private final MemberService memberService;

    // 로그인 페이지
    @GetMapping("/member/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/member/join")
    public String joinForm() {
        return "join";
    }

    @PostMapping("/member/join")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        return "index";
    }
}
