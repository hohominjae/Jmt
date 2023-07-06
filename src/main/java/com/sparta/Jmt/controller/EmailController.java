package com.sparta.Jmt.controller;

import com.sparta.Jmt.dto.EmailCheckDto;
import com.sparta.Jmt.dto.EmailRequestDto;
import com.sparta.Jmt.dto.MsgResponseDto;
import com.sparta.Jmt.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jmt")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sign-up/mail-send")
    public String MailSend(@RequestBody EmailRequestDto requestDto) {

        int number = emailService.sendMail(requestDto.getUserEmail());

        String num = "" + number;

        return num;
    }

    @PostMapping("/sign-up/mail-check")
    public ResponseEntity<MsgResponseDto> AuthCheck(@RequestBody @Valid EmailCheckDto emailCheckDto) {
        Boolean checkedAuthNum = emailService.checkAuthNum(emailCheckDto.getUserEmail(), emailCheckDto.getAuthNum());
        if (checkedAuthNum) {
            return ResponseEntity.ok().body(new MsgResponseDto("이메일 인증 성공", HttpStatus.OK.value()));
        }
        throw new IllegalArgumentException("인증번호가 틀렸습니다");
    }
}
