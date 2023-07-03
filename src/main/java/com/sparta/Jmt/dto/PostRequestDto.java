package com.sparta.Jmt.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String postTitle;
    private String postContent;
    private String postCategory;
    private String jmtName;
    private String jmtLocation;
    private String jmtMenu;
    private String jmtImage;
    private String jmtScore;

    public PostRequestDto() {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postCategory = postCategory;
        this.jmtName = jmtName;
        this.jmtLocation = jmtLocation;
        this.jmtMenu = jmtMenu;
        this.jmtImage = jmtImage;
        this.jmtScore = jmtScore;
    }
}
