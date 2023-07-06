package com.sparta.Jmt.service;

import com.sparta.Jmt.dto.UserRequestDto;
import com.sparta.Jmt.entity.User;
import com.sparta.Jmt.repository.UserRepository;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.net.URL;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JavaMailSender javaMailSender;
    private static final String senderEmail= "reason9550@gmail.com";
    private static int number;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SpringTemplateEngine springTemplateEngine;

    public void signup(UserRequestDto requestDto) {
        String userName = requestDto.getUserName();
        String password = passwordEncoder.encode(requestDto.getUserPassword());
        String profileComment = requestDto.getProfileComment();
        URL profileImage = requestDto.getProfileImage();
        String userEmail = requestDto.getUserEmail();

        // 회원 중복 확인
        Optional<User> checkUserId = userRepository.findByUserName(userName);
        if (checkUserId.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        Optional<User> checkUserEmail = userRepository.findByUserEmail(userEmail);
        if (checkUserEmail.isPresent()) {
            throw new IllegalArgumentException("중복된 이메일이 존재합니다");
        }

        // 사용자 등록
        User user = new User(userName, password, profileComment, profileImage, userEmail);
        userRepository.save(user);
    }

    public static void createNumber(){
        number = (int)(Math.random() * (90000)) + 100000;// (int) Math.random() * (최댓값-최소값+1) + 최소값
    }

    public MimeMessage CreateMail(String mail){
        createNumber();
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, mail);
            message.setSubject("이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8", "html");
        } catch (jakarta.mail.MessagingException e) {
            e.printStackTrace();
        }

        return message;
    }

    public int sendMail(String mail){
        MimeMessage message = CreateMail(mail);
        javaMailSender.send(message);

        return number;
    }
}