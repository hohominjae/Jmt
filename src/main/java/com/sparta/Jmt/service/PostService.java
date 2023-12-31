package com.sparta.Jmt.service;

import com.sparta.Jmt.dto.*;
import com.sparta.Jmt.entity.Post;
import com.sparta.Jmt.entity.PostCategory;
import com.sparta.Jmt.entity.User;
import com.sparta.Jmt.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(PostRequestDto postRequestDto, User user) {

        // RequestDto -> Entity(게시글 생성)
        Post post = new Post(postRequestDto);
        post.setUser(user);

        // DB 저장
        postRepository.save(post);
    }

    //전체 게시물 보기
    public PostListResponseDto getPosts() {
        List<PostResponseDto> postList = postRepository.findAllByOrderByModifiedAtDesc()
                .stream().map(PostResponseDto::new).collect(Collectors.toList());
        return new PostListResponseDto(postList);
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
    public PostResponseDto getPostById(Long postId) {
        //Post 형태로 postId에 맞는 게시글 찾기
        Post post = findPost(postId);

        //Post 형태의 찾은 게시물을 ResponseDto로 받아오기
        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long postId, PostRequestDto requestDto, User user) {
        // 해당 포스트가 DB에 존재하는지 확인
        Post post = findPost(postId);
        //게시글 작성자(post.user)와 요청자(user)가 같은지 학인
        if (!post.getUser().equals(user)) {
            throw new RejectedExecutionException();
        }
        // post 내용 수정
        post.update(requestDto);

        return new PostResponseDto(post);
    }

    public void deletePost(Long postId, User user) {
        // 해당 포스트가 DB에 존재하는지 확인
        Post post = findPost(postId);
        //게시글 작성자(post.user)와 요청자(user)가 같은지 학인
        if (!post.getUser().equals(user)) {
            throw new RejectedExecutionException();
        }
        // post 삭제
        postRepository.delete(post);
    }

    private Post findPost(Long postId) {
        return postRepository.findById(postId).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글이 존재하지 않습니다."));
    }
}
