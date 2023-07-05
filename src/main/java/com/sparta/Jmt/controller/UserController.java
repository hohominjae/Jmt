package com.sparta.Jmt.controller;

import com.sparta.Jmt.dto.MsgResponseDto;
import com.sparta.Jmt.dto.UserRequestDto;
import com.sparta.Jmt.jwt.JwtUtil;
import com.sparta.Jmt.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jmt")
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<MsgResponseDto> signup(@RequestBody UserRequestDto requestDto) {
        userService.signup(requestDto);
        return ResponseEntity.status(201).body(new MsgResponseDto("회원가입 성공", HttpStatus.CREATED.value()));
    }
}
