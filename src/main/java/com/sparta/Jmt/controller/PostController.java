package com.sparta.Jmt.controller;

import com.sparta.Jmt.dto.PostListResponseDto;
import com.sparta.Jmt.dto.PostRequestDto;
import com.sparta.Jmt.dto.PostResponseDto;
import com.sparta.Jmt.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jmt")
public class PostController {

    //의존성 주입 받기위해 Service를 빈으로 등록 후 받아온다.
    //우리가 사용한 방법 생성자 주입
    private final PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }

    //게시물 작성
    @PostMapping("/post")
    public PostResponseDto createPost(PostRequestDto requestDto){

        return postService.createPost(requestDto);
    }

    @GetMapping("/posts")
    public PostListResponseDto getPosts(){

        return postService.getPosts();
    }

    @GetMapping("/post/{postId}")
    public PostResponseDto getPost(Long postId){

        return postService.getPost(postId);
    }

    @PutMapping("/post/{postId}")
    public void updatePost(Long postId, PostRequestDto requestDto){
        postService.updatePost(postId, requestDto);
    }

    @DeleteMapping("/post/{postId}")
    public void deletePost(Long postId){
        postService.deletePost(postId);
    }

}
