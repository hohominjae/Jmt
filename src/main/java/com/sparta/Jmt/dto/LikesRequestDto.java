package com.sparta.Jmt.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LikesRequestDto {
    private int postLikes;
    private Long userId;
    private Long postId;
}
