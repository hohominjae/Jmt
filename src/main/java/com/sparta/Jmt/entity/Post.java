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

    @Column(nullable = false)
    private String jmtName;

    @Column(nullable = false)
    private String jmtLocation;

    @Column(nullable = false)
    private String jmtMenu;

    @Column
    private URL jmtImage;

    @Column(nullable = false)
    private float jmtScore;


    @ManyToOne
    private User user;

    public Post(PostRequestDto postRequestDto) {
        this.postTitle = postRequestDto.getPostTitle();
        this.postContent = postRequestDto.getPostContent();
        this.postCategory = postRequestDto.getPostCategory();
        this.jmtName = postRequestDto.getJmtName();
        this.jmtLocation = postRequestDto.getJmtLocation();
        this.jmtMenu = postRequestDto.getJmtMenu();
        this.jmtImage = postRequestDto.getJmtImage();
        this.jmtScore = postRequestDto.getJmtScore();
    }

    public void updatePost(PostRequestDto requestDto){
        this.postTitle = requestDto.getPostTitle();
        this.postContent = requestDto.getPostContent();
        this.postCategory = requestDto.getPostCategory();
        this.jmtName = requestDto.getJmtName();
        this.jmtLocation = requestDto.getJmtLocation();
        this.jmtMenu = requestDto.getJmtMenu();
        this.jmtImage = requestDto.getJmtImage();
        this.jmtScore = requestDto.getJmtScore();
    }

}
