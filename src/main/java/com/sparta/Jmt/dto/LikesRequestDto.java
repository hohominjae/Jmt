package com.sparta.Jmt.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LikesRequestDto {
    private Long userId;
    private Long postId;
}
