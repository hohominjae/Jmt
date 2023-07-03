package com.sparta.Jmt.dto;

import com.sparta.Jmt.entity.Post;
import lombok.Getter;

import java.net.URL;

@Getter
public class PostRequestDto {
    private String postTitle;
    private String postContent;
    private String postCategory;
    private String jmtName;
    private String jmtLocation;
    private String jmtMenu;
    private URL jmtImage;
    private float jmtScore;

    public PostRequestDto(Post post) {
        this.postTitle = getPostTitle();
        this.postContent = getPostContent();
        this.postCategory = getPostCategory();
        this.jmtName = getJmtName();
        this.jmtLocation = getJmtLocation();
        this.jmtMenu = getJmtMenu();
        this.jmtImage = getJmtImage();
        this.jmtScore = getJmtScore();
    }
}
