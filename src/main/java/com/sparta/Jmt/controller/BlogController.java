package com.sparta.Jmt.controller;

import com.sparta.Jmt.entity.Post;
import com.sparta.Jmt.entity.PostCategory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/")
    public String homepage(Model model) {

        Post post = new Post();
        post.setPostId(1L);
        post.setPostTitle("종로 맛집을 소개합니다");
        post.setPostContent("원래도 감자를 좋아하긴 하쥐만... 감자그라탕 진짜 JMT...ㅜㅜ");
        post.setPostCategory(PostCategory.FRENCHFOOD);
        post.setStoreName("르블란서");
        post.setStoreLocation("서울 종로구 익선동 170-1");
        post.setStoreScore(10.0F);

        model.addAttribute("post", post);

        return "index";
    }
}