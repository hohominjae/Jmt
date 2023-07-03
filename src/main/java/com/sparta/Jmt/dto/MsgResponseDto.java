package com.sparta.Jmt.dto;

import lombok.Getter;

@Getter
public class MsgResponseDto {
    private String message;
    private Integer statusCode;

    public MsgResponseDto(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
