//package com.sparta.Jmt.service;
//
//import com.sparta.Jmt.dto.PostCategoryListResponseDto;
//import com.sparta.Jmt.dto.PostResponseDto;
//import com.sparta.Jmt.repository.PostCategoryRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PostCategoryService {
//
//    private final PostCategoryRepository postCategoryRepository;
//
//    public PostCategoryService(PostCategoryRepository postCategoryRepository) {
//        this.postCategoryRepository = postCategoryRepository;
//    }
//
//    //카테고리 조회
//    public PostCategoryListResponseDto getPostByCategory(){
//        PostCategoryListResponseDto postCategoryListResponseDto = new PostCategoryListResponseDto(postCategoryRepository.findAllByPostCategoryGreaterThanEqual().stream().map(PostResponseDto::new).toList());
//
//        return postCategoryListResponseDto;
//    }
//}
