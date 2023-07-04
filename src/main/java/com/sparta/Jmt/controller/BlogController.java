package com.sparta.Jmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/home")
    public String homepage() {
        return "index";
    }
}
