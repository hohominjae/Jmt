package com.sparta.Jmt.dto;

import com.sparta.Jmt.entity.PostCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostRequestDto {
    private String postTitle;
    private String postContent;
    private PostCategory postCategory;
    private int postLikes;
    private String storeName;
    private String storeLocation;
    private float storeScore;
    private String jmtMenuName;
    private String jmtMenuImageUrl;
}
