package com.sparta.Jmt.controller;

import com.sparta.Jmt.dto.MsgResponseDto;
import com.sparta.Jmt.dto.PostListResponseDto;
import com.sparta.Jmt.dto.PostRequestDto;
import com.sparta.Jmt.dto.PostResponseDto;
import com.sparta.Jmt.entity.Post;
import com.sparta.Jmt.entity.PostCategory;
import com.sparta.Jmt.security.UserDetailsImpl;
import com.sparta.Jmt.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.RejectedExecutionException;

//병합용 주석
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
    public ResponseEntity<PostResponseDto> createPost(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody PostRequestDto requestDto){
        PostResponseDto result = postService.createPost(requestDto, userDetails.getUser());
        return ResponseEntity.status(201).body(result);
    }

    @GetMapping("/posts")//글 전체 조회
    public ResponseEntity<PostListResponseDto> getPosts(){
        PostListResponseDto result = postService.getPosts();
        return ResponseEntity.ok().body(result);
    }

//    @GetMapping("/post/{postId}")//글 단건 조회
//    public String getPostOne(Model model){
//
//    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<PostResponseDto> updatePost(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long postId, @RequestBody PostRequestDto requestDto){
        try{
            PostResponseDto result = postService.updatePost(postId, requestDto, userDetails.getUser());
            return ResponseEntity.ok().body(result);
        }catch(RejectedExecutionException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<MsgResponseDto> deletePost(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long postId){
        try{
            postService.deletePost(postId, userDetails.getUser());
            return ResponseEntity.ok().body(new MsgResponseDto("게시글 삭제 성공", HttpStatus.OK.value()));
        }catch(RejectedExecutionException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
