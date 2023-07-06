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

    @Column
    private String postTitle;

    @Column
    private String postContent;

    @Column
    @Enumerated(EnumType.STRING)
    private PostCategory postCategory;

    @Column
    private String jmtName;

    @Column
    private String jmtLocation;

    @Column
    private String jmtMenu;

    @Column
    private URL jmtImage;

    @Column
    private float jmtScore;

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
