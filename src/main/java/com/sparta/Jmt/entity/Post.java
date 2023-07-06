package com.sparta.Jmt.entity;

import com.sparta.Jmt.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(mappedBy = "post")
//    @OrderBy("id asc") // 댓글 정렬
    private List<Comment> comments;


    public Post(PostRequestDto requestDto) {
        this.postTitle = requestDto.getPostTitle();
        this.postContent = requestDto.getPostContent();
        this.postCategory = requestDto.getPostCategory();
        this.storeName = requestDto.getStoreName();
        this.storeLocation = requestDto.getStoreLocation();
        this.storeScore = requestDto.getStoreScore();
        this.jmtMenuName = requestDto.getJmtMenuName();
        this.jmtMenuImageUrl = requestDto.getJmtMenuImageUrl();
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