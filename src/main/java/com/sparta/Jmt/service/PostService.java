package com.sparta.Jmt.service;

import com.sparta.Jmt.dto.PostListResponseDto;
import com.sparta.Jmt.dto.PostRequestDto;
import com.sparta.Jmt.dto.PostResponseDto;
import com.sparta.Jmt.entity.Post;
import com.sparta.Jmt.entity.User;
import com.sparta.Jmt.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDto createPost(PostRequestDto postRequestDto,User user){
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

    //선택한 게시물 보기
    public PostResponseDto getPost(Long postId) {
        //Post형태로 postId에 맞는 게시글 찾기
        Post post = findById(postId);

        //Post 형태의 찾은 게시물을 ResponseDto로 바꿔주기
        PostResponseDto postResponseDto = new PostResponseDto(post);
        return postResponseDto;
    }

    public void updatePost(Long postId, PostRequestDto requestDto, User user){
        //Post형태로 postId에 맞는 게시글 찾기
        Post post = findById(postId);

        //불러온 게시물을 수정
        post.updatePost(requestDto);
    }

    public void deletePost(Long postId,User user){
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
