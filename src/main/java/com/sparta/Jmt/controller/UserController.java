package com.sparta.Jmt.controller;

import com.sparta.Jmt.dto.MsgResponseDto;
import com.sparta.Jmt.dto.UserRequestDto;
import com.sparta.Jmt.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/jmt/sign-up")
    public MsgResponseDto signup(@RequestBody UserRequestDto requestDto) {
        userService.signup(requestDto);
        return new MsgResponseDto("회원가입 성공", 200);
    }

    @PostMapping("/jmt/login")
    public MsgResponseDto login(@RequestBody UserRequestDto requestDto, HttpServletResponse res) {
//        try {
            userService.login(requestDto, res);
//        } catch (Exception e) {
//            e.getMessage();
//        }
        return new MsgResponseDto("로그인 성공", 200);
    }
}
