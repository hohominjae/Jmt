package com.sparta.Jmt.dto;

import com.sparta.Jmt.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.time.LocalDateTime;

@Getter
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

    private String jmtMenuName;
    private URL jmtMenuImageUrl;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PostResponseDto(Post post) {
        this.userName = post.getUser().getUserName();
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
    }
}