package com.example.shimakiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @GetMapping("/index")
    public String index() {
        return "bookmark";
    }

}