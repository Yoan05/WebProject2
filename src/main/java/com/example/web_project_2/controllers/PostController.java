package com.example.web_project_2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {

    @GetMapping("/posts/create")
    public ModelAndView createPost(){
        return new ModelAndView("create-post");
    }
}
