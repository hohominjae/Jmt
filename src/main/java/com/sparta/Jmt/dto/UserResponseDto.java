package com.sparta.Jmt.dto;

import lombok.Getter;

import java.net.URL;

@Getter
public class UserResponseDto {
    private String userName;
    private String userPassword;
    private String profileComment;
    private URL profileImage;

    public UserResponseDto(String userName, String userPassword, String profileComment, URL profileImage) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.profileComment = profileComment;
        this.profileImage = profileImage;
    }
}
