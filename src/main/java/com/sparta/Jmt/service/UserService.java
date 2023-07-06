package com.sparta.Jmt.service;

import com.sparta.Jmt.dto.UserRequestDto;
import com.sparta.Jmt.entity.User;
import com.sparta.Jmt.jwt.JwtUtil;
import com.sparta.Jmt.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
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
    private final JwtUtil jwtUtil;

    public void signup(UserRequestDto requestDto) {
        String userName = requestDto.getUserName();
        String password = passwordEncoder.encode(requestDto.getUserPassword());
        String profileComment = requestDto.getProfileComment();
        URL profileImageUrl = requestDto.getProfileImageUrl();

        // 회원 중복 확인
        Optional<User> checkUserId = userRepository.findByUserName(userName);
        if (checkUserId.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        // 사용자 등록
        User user = new User(userName, password, profileComment, profileImageUrl);
        userRepository.save(user);
    }

    public void login(UserRequestDto requestDto, HttpServletResponse res) {
        String userId = requestDto.getUserName();
        String password = requestDto.getUserPassword();

        // 사용자 확인
        User user = userRepository.findByUserName(userId).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        // 비밀번호 확인
        if (!passwordEncoder.matches(password, user.getUserPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // JWT 생성 및 쿠키에 저장 후 Response 객체에 추가
        String token = jwtUtil.createToken(user.getUserName());
        jwtUtil.addJwtToCookie(token, res);
    }
}