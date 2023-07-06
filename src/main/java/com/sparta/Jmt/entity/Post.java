package com.sparta.Jmt.entity;

import com.sparta.Jmt.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.net.URL;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "posts")
public class Post extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String postContent;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PostCategory postCategory;

    @Column(name = "postLikes", nullable = false)
    @ColumnDefault("0")
    private int postLikes;

    @Column(nullable = false)
    private String storeName;

    @Column(nullable = false)
    private String storeLocation;

    @Column(nullable = false)
    private float storeScore;

    @Column(nullable = false)
    private String jmtMenuName;

    @Column
    private String jmtMenuImageUrl;


    @JoinColumn
    @ManyToOne
    private User user;

    public Post(PostRequestDto postRequestDto) {
        this.postTitle = postRequestDto.getPostTitle();
        this.postContent = postRequestDto.getPostContent();
        this.postCategory = postRequestDto.getPostCategory();
        this.storeName = postRequestDto.getStoreName();
        this.storeLocation = postRequestDto.getStoreLocation();
        this.storeScore = postRequestDto.getStoreScore();
        this.jmtMenuName = postRequestDto.getJmtMenuName();
        this.jmtMenuImageUrl = postRequestDto.getJmtMenuImageUrl();
    }

    public void update(PostRequestDto requestDto) {
        this.postTitle = requestDto.getPostTitle();
        this.postContent = requestDto.getPostContent();
        this.postCategory = requestDto.getPostCategory();
        this.storeName = requestDto.getStoreName();
        this.storeLocation = requestDto.getStoreLocation();
        this.storeScore = requestDto.getStoreScore();
        this.jmtMenuName = requestDto.getJmtMenuName();
        this.jmtMenuImageUrl = requestDto.getJmtMenuImageUrl();
    }

    public void plusLikes() {
        this.postLikes++;
    }
    public void minusLikes() {
        this.postLikes--;
    }
}