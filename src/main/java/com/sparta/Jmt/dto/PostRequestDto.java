package com.sparta.Jmt.dto;

import com.sparta.Jmt.entity.Post;
import lombok.Getter;

import java.net.URL;

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
