package com.example.shimakiti.controller;

import com.example.shimakiti.servise.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @Autowired
    private IUserService userService;

    @GetMapping("index")
    public String index() {
        return "post-insert";
    }
    @GetMapping("sample")
    public String sample() {
        return "register";
    }

}