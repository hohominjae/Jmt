package com.sparta.Jmt.dto;

import com.sparta.Jmt.entity.PostCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
@AllArgsConstructor
public class PostRequestDto {
    private Long id;
    private String postTitle;
    private String postContent;
    private PostCategory postCategory;
    private String storeName;
    private String storeLocation;
    private float storeScore;
    private String jmtMenuName;
    private String jmtMenuImageUrl;

    //jmtImage 삽입을 위한 생성자 생성
    public PostRequestDto(String jmtNa) {
        this.jmtMenuName = jmtMenuName;
        this.jmtMenuImageUrl = jmtMenuImageUrl;
    }
}
