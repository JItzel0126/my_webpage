package com.mywebpage.mywebpage.user.controller;

import com.mywebpage.mywebpage.user.dto.UserRequestDto;
import com.mywebpage.mywebpage.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

//    회원가입
    @PostMapping("/signup")
    public String signup(UserRequestDto user,
                         Model model) {
        try {
            userService.register(user);
            return "redirect:/login";    // 성공하면 /login 으로
        } catch (Exception e) {
//          그냥 thro 하면 CommonException에서 처리됨
            throw e;
        }
    }

}
