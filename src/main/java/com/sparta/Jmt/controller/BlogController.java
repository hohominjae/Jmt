package com.sparta.Jmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/thymeleaf/")
    public String homepage(Model model) {

        return "index";
    }
}
