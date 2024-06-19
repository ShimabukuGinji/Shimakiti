package com.example.shimakiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginFormController {
    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @PostMapping("/login")
    public String login1() {
        return "search";
    }
}