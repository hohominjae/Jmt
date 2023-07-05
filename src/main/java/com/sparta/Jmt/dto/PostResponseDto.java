package com.sparta.Jmt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sparta.Jmt.entity.Post;
import com.sparta.Jmt.entity.PostCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String postTitle;
    private String postContent;
    private PostCategory postCategory;
    private String jmtName;
    private String jmtLocation;
    private String jmtMenu;
    private URL jmtImage;
    private float jmtScore;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PostResponseDto(Post post) {
        this.id = post.getPostId();
        this.postTitle = post.getPostTitle();
        this.postContent = post.getPostContent();
        this.postCategory = post.getPostCategory();
        this.jmtName = post.getJmtName();
        this.jmtLocation = post.getJmtLocation();
        this.jmtMenu = post.getJmtMenu();
        this.jmtImage = post.getJmtImage();
        this.jmtScore = post.getJmtScore();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }

}