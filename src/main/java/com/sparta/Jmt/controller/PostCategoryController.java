//package com.sparta.Jmt.controller;
//
//import com.sparta.Jmt.dto.PostCategoryListResponseDto;
//import com.sparta.Jmt.service.PostCategoryService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/jmt")
//public class PostCategoryController {
//    private final PostCategoryService postCategoryService;
//
//    public PostCategoryController(PostCategoryService postCategoryService) {
//        this.postCategoryService = postCategoryService;
//    }
//
//    @GetMapping("/category")
//    public PostCategoryListResponseDto getPostByCategory(){
//
//        return postCategoryService.getPostByCategory();
//    }
//
//}
