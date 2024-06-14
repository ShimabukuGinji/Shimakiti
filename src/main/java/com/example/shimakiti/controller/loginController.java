package com.example.shimakiti.controller;

import com.example.shimakiti.servise.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @Autowired
    private IUserService userService;

    @GetMapping("sample")
    public String index() {
        System.out.println(userService.findAll());
        return "post-insert";
    }
}