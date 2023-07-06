package com.sparta.Jmt.dto;

import lombok.Getter;

import java.net.URL;

@Getter
public class UserResponseDto {
    private String userName;
    private String userPassword;
    private String profileComment;
    private URL profileImageUrl;

    public UserResponseDto(User user) {
        this.userName = user.getUserName();
        this.userPassword = user.getUserPassword();
        this.profileComment = user.getProfileComment();
        this.profileImageUrl = user.getProfileImageUrl();
    }
}
