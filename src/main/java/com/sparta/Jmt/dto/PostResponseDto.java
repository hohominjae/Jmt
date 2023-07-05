package com.sparta.Jmt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sparta.Jmt.entity.Post;
import com.sparta.Jmt.entity.PostCategory;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class PostResponseDto {
    private Long id;

    @NotBlank(message = "글의 제목을 입력해주세요.")
    private String postTitle;

    @NotBlank(message = "글의 내용을 입력해주세요.")
    private String postContent;

    private PostCategory postCategory;

    private String storeName;
    private String storeLocation;
    private float storeScore;

    //이미지 식별자 정보를 저장하는 리스트
    private List<Long> jmtImageIdList = new ArrayList<>();
    //이미지 정보를 저장하는 리스트
    private List<PostRequestDto> jmtImageDtoList = new ArrayList<>();

    public PostResponseDto(Post post) {
        this.id = post.getPostId();
        this.postTitle = post.getPostTitle();
        this.postContent = post.getPostContent();
        this.postCategory = post.getPostCategory();
        this.storeName = post.getStoreName();
        this.storeLocation = post.getStoreLocation();
        this.storeScore = post.getStoreScore();
    }
}