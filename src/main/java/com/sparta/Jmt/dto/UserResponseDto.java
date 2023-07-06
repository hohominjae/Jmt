package com.sparta.Jmt.dto;

import com.sparta.Jmt.entity.User;
import lombok.Getter;

import java.net.URL;

@Getter
public class UserResponseDto {
    private String userName;
    private String userPassword;
    private String userNick;
    private String profileComment;
    private URL profileImage;

    public UserResponseDto(String userName, String userPassword, String userNick, String profileComment, URL profileImage) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userNick = userNick;
        this.profileComment = profileComment;
        this.profileImage = profileImage;
    }
}
