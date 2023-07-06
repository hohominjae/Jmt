package com.sparta.Jmt.dto;

import com.sparta.Jmt.entity.Comment;
import com.sparta.Jmt.entity.Post;
import com.sparta.Jmt.entity.PostCategory;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private String userNick;

    @NotBlank(message = "글의 제목을 입력해주세요.")
    private String postTitle;

    @NotBlank(message = "글의 내용을 입력해주세요.")
    private String postContent;

    private PostCategory postCategory;

    private String storeName;
    private String storeLocation;
    private float storeScore;

    private String jmtMenuName;
    private URL jmtMenuImageUrl;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<CommentResponseDto> comments;

    public PostResponseDto(Post post) {
        this.userNick = post.getUser().getUserNick();
        this.postTitle = post.getPostTitle();
        this.postContent = post.getPostContent();
        this.postCategory = post.getPostCategory();
        this.storeName = post.getStoreName();
        this.storeLocation = post.getStoreLocation();
        this.storeScore = post.getStoreScore();
        this.jmtMenuName = post.getJmtMenuName();
        this.jmtMenuImageUrl = post.getJmtMenuImageUrl();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        List<CommentResponseDto> commentList = new ArrayList<>();
        for (Comment comment : post.getComments()) {
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
            commentList.add(commentResponseDto);
        }
        this.comments = commentList;
    }
}