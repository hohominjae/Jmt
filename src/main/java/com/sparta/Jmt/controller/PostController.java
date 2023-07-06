package com.sparta.Jmt.controller;

import com.sparta.Jmt.dto.PostCategoryListResponseDto;
import com.sparta.Jmt.dto.PostListResponseDto;
import com.sparta.Jmt.dto.PostRequestDto;
import com.sparta.Jmt.dto.PostResponseDto;
import com.sparta.Jmt.entity.PostCategory;
import com.sparta.Jmt.service.PostService;
import lombok.Value;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto postRequestDto){
        PostResponseDto result = postService.createPost(postRequestDto);
        return ResponseEntity.status(201).body(result);
    }

    @GetMapping("/posts")
    public PostListResponseDto getPosts(){

        return postService.getPosts();
    }

    //카테고리 선택 조회
    @GetMapping("/category")
    public PostCategoryListResponseDto getPostByCategory(@RequestParam PostCategory postCategory) {

        return postService.getPostByCategory(postCategory);
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
