package com.sparta.Jmt.dto;

import lombok.Getter;

import java.net.URL;

@Getter
public class UserResponseDto {
    private String userId;
    private String userPassword;
    private String userName;
    private String profileComment;
    private URL profileImage;

    public UserResponseDto(String userId, String userPassword, String userName, String profileComment, URL profileImage) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.profileComment = profileComment;
        this.profileImage = profileImage;
    }
}
