package com.sparta.Jmt.dto;

import lombok.Getter;

import java.util.List;
@Getter
public class PostCategoryListResponseDto {
    private List<PostResponseDto> postsList;

    public PostCategoryListResponseDto(List<PostResponseDto> postList) {
        this.postsList = postList;

    }
}
