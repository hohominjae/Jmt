package com.sparta.Jmt.dto;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Setter
@Getter
public class UserRequestDto {
    private String userName;
    private String userPassword;
    private String profileComment;
    private URL profileImage;
    private String userEmail;
}
