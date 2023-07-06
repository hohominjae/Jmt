package com.sparta.Jmt.dto;

import com.sparta.Jmt.entity.Comment;
import com.sparta.Jmt.entity.PostCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostRequestDto {
    private String postTitle;
    private String postContent;
    private PostCategory postCategory;
    private String storeName;
    private String storeLocation;
    private float storeScore;
    private String jmtMenuName;
    private URL jmtMenuImageUrl;
}
