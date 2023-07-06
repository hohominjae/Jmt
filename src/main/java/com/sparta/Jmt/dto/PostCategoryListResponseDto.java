package com.sparta.Jmt.dto;

import lombok.Getter;

import java.util.List;
@Getter
public class PostCategoryListResponseDto {
    private List<PostResponseDto> postCategoryList;

    public PostCategoryListResponseDto(List<PostResponseDto> postCategoryListList) {
        this.postCategoryList = postCategoryListList;

    }
}
