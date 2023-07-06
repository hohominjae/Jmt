package com.sparta.Jmt.controller;

import com.sparta.Jmt.dto.UserRequestDto;
import com.sparta.Jmt.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jmt")
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sign-up/confirm")
    public String MailSend(@RequestBody UserRequestDto requestDto){

        int number = emailService.sendMail(requestDto.getUserEmail());

        String num = "" + number;

        return num;
    }
}
