package com.sparta.Jmt.service;

import com.sparta.Jmt.dto.*;
import com.sparta.Jmt.entity.Post;
import com.sparta.Jmt.entity.PostCategory;
import com.sparta.Jmt.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDto createPost(PostRequestDto postRequestDto){
        Post post = new Post(postRequestDto);

        postRepository.save(post);

        PostResponseDto postResponseDto = new PostResponseDto(post);
        return postResponseDto;
    }

    //전체 게시물 보기
    public PostListResponseDto getPosts() {
        PostListResponseDto postListResponseDto = new PostListResponseDto(postRepository.findAllByOrderByModifiedAtDesc().stream().map(PostResponseDto::new).toList());

        return postListResponseDto;
    }

    //카테고리 조회
    public PostCategoryListResponseDto getPostByCategory(PostCategory postCategory){
        PostCategoryListResponseDto postCategoryListResponseDto = new PostCategoryListResponseDto(postRepository.findByPostCategory(postCategory).stream().map(PostResponseDto::new).toList());

        return postCategoryListResponseDto;
    }

    //제목으로 조회
    public PostTitleListResponseDto getPostByTitle(String postTitle){
        PostTitleListResponseDto postTitleListResponseDto = new PostTitleListResponseDto(postRepository.findByPostTitle(postTitle).stream().map(PostResponseDto::new).toList());

        return postTitleListResponseDto;
    }

    //선택한 게시물 보기
    public PostResponseDto getPost(Long postId) {
        //Post형태로 postId에 맞는 게시글 찾기
        Post post = findById(postId);

        //Post 형태의 찾은 게시물을 ResponseDto로 바꿔주기
        PostResponseDto postResponseDto = new PostResponseDto(post);
        return postResponseDto;
    }

    public void updatePost(Long postId,PostRequestDto requestDto){
        //Post형태로 postId에 맞는 게시글 찾기
        Post post = findById(postId);

        //불러온 게시물을 수정
        post.updatePost(requestDto);
    }

    public void deletePost(Long postId){
        //Post형태로 postId에 맞는 게시글 찾기
        Post post = findById(postId);

        //불러온 게시물을 삭제
        postRepository.delete(post);
    }

    public Post findById(Long postId){
        return postRepository.findById(postId).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글이 존재하지 않습니다."));
    }
}
