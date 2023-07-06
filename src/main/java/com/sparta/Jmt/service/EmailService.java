package com.sparta.Jmt.service;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private static final String senderEmail = "reason9550@gmail.com";
    private static int number;

    public static void createNumber() {
        number = (int) (Math.random() * (90000)) + 100000;// (int) Math.random() * (최댓값-최소값+1) + 최소값
    }

    public MimeMessage CreateMail(String userEmail) {
        createNumber();
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, userEmail);
            message.setSubject("이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body, "UTF-8", "html");
        } catch (jakarta.mail.MessagingException e) {
            e.printStackTrace();
        }

        return message;
    }

    public int sendMail(String userEmail) {
        MimeMessage message = CreateMail(userEmail);
        javaMailSender.send(message);

        return number;
    }

    public Boolean checkAuthNum(String userEmail, String authNum) {
        String num = "" + number;
        if (num.equals(authNum)) {
            return true;
        }
        throw new IllegalArgumentException("인증번호가 틀렸습니다.");
    }
}