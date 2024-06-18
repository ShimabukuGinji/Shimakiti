package com.example.shimakiti.controller;

import com.example.shimakiti.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @Autowired
    private IUserService userService;


    @GetMapping("/index")
    public String index() {
        return "post-insert";
    }

}