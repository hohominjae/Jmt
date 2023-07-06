package com.sparta.Jmt.service;

import com.sparta.Jmt.dto.UserRequestDto;
import com.sparta.Jmt.entity.User;
import com.sparta.Jmt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(UserRequestDto requestDto) {
        String userName = requestDto.getUserName();
        String password = passwordEncoder.encode(requestDto.getUserPassword());
        String profileComment = requestDto.getProfileComment();
        URL profileImageUrl = requestDto.getProfileImageUrl();
        String userEmail = requestDto.getUserEmail();

        // 회원 중복 확인
        Optional<User> checkUserId = userRepository.findByUserName(userName);
        if (checkUserId.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        // 이메일 중복 확인
        Optional<User> checkUserEmail = userRepository.findByUserEmail(userEmail);
        if (checkUserEmail.isPresent()) {
            throw new IllegalArgumentException("중복된 이메일이 존재합니다");
        }

        // 사용자 등록
        User user = new User(userName, password, profileComment, profileImageUrl, userEmail);
        userRepository.save(user);
    }
}