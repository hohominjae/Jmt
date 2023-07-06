package com.sparta.Jmt.dto;

import com.sparta.Jmt.entity.Likes;

public class LikesResponseDto {
    private Long userId;
    private Long postId;

    public LikesResponseDto(Likes likes) {
        this.userId = likes.getUser().getId();
        this.postId = likes.getPost().getPostId();
    }
}
