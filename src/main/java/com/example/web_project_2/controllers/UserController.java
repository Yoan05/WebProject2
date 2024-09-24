package com.example.web_project_2.controllers;

import com.example.web_project_2.models.dtos.UserRegisterDto;
import com.example.web_project_2.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    @PostMapping("/users/register")
    public ModelAndView register(UserRegisterDto userRegisterDto){
        if (userService.register(userRegisterDto)) {
            return new ModelAndView("redirect:/users/login");
        } else {
            return new ModelAndView("redirect:/users/register");
        }
    }

    @GetMapping("/users/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @GetMapping("/error/login-error")
    public ModelAndView loginError(){
        return new ModelAndView("login-error");
    }

    @GetMapping("/users/my-profile")
    public ModelAndView myProfile(){
        ModelAndView model = new ModelAndView("my-profile-page");
        model.addObject("currentUser" ,userService.getCurrentUser());
        return model;
    }
}
