package com.example.shimakiti.controller;

import com.example.shimakiti.entity.User;
import com.example.shimakiti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginFormController {

    @Autowired
    UserService userService;
    @GetMapping("/login")
    public String login(@RequestParam(name = "error", required = false)String error, Model model) {
        if(error != null){
            model.addAttribute("error",true);
        }
        return "login";
    }

    @GetMapping("/account/admin")
    public String admin(@ModelAttribute("userForm") User user) {
        return "user-add";
    }

    @PostMapping("/account/admin")
    public String adminInsert(@Validated @ModelAttribute("userForm") User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "user-add";
        }
        userService.insert(user);
        return "login";
    }

}