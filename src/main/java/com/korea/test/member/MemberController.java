package com.korea.test.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(String username, String password, String nickname, String email) {
        memberService.join(username,password,nickname,email);
        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login_form";
    }
}
