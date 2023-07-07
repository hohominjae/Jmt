package com.sparta.Jmt.dto;

import com.sparta.Jmt.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private final String userName;
    private final String Content;
    private final Long postId;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentResponseDto(Comment comment) {
        this.userName = comment.getUser().getUserName();
        this.Content = comment.getContent();
        this.postId = comment.getPost().getPostId();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
