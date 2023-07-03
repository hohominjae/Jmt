package com.sparta.Jmt.dto;

import com.sparta.Jmt.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.time.LocalDateTime;

@Getter
@Setter
public class PostResponseDto{
    private String postTitle;
    private String postContent;
    private String postCategory;
    private String jmtName;
    private String jmtLocation;
    private String jmtMenu;
    private URL jmtImage;
    private float jmtScore;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PostResponseDto(Post post) {
        this.postTitle = getPostTitle();
        this.postContent = getPostContent();
        this.postCategory = getPostCategory();
        this.jmtName = getJmtName();
        this.jmtLocation = getJmtLocation();
        this.jmtMenu = getJmtMenu();
        this.jmtImage = getJmtImage();
        this.jmtScore = getJmtScore();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }

}