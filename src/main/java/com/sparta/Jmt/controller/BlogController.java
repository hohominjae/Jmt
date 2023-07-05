package com.sparta.Jmt.controller;

import com.sparta.Jmt.entity.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/thymeleaf/")
    public String homepage(Model model) {
        Post post = new Post();
        model.addAttribute("post", post); //Model 객체에 Post 객체 저장

        return "index"; //뷰의 이름 반환
    }
}
