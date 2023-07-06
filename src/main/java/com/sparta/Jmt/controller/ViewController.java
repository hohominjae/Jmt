package com.sparta.Jmt.controller;

import com.sparta.Jmt.dto.PostRequestDto;
import com.sparta.Jmt.dto.PostResponseDto;
import com.sparta.Jmt.repository.PostRepository;
import com.sparta.Jmt.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ViewController {
    private final PostService postService;

    @GetMapping("/")
    public String homePage(Model model) {
        List<PostResponseDto> postList = postService.findAll().stream()
                .map(PostResponseDto::new)
                .toList();
        model.addAttribute("postList", postList);

        return "index";
    }
}
