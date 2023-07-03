package com.sparta.Jmt.dto;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;
@Setter
@Getter
public class UserRequestDto {
    private String userId;
    private String userPassword;
    private String userName;
    private String profileComment;
//    private URL profileImage;
}
