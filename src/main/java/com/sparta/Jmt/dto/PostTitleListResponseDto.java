package com.sparta.Jmt.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PostTitleListResponseDto {
    private List<PostResponseDto> postTitleList;

    public PostTitleListResponseDto(List<PostResponseDto> postTitleList) {
        this.postTitleList = postTitleList;

    }
}
