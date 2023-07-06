package com.sparta.Jmt.dto;

import com.sparta.Jmt.entity.Post;
import com.sparta.Jmt.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {
    private String content;
    private Long postId;
}
