package com.example.web_project_2.controllers;

import com.example.web_project_2.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("home");
        model.addObject("currentUser" ,userService.getCurrentUser());
        return model;
    }

    @GetMapping("/error")
    public ModelAndView error(){
        return new ModelAndView("error");
    }
}
