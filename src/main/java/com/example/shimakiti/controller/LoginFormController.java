package com.example.shimakiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginFormController {
    @GetMapping("/login")
    public String login(@RequestParam(name = "error", required = false)String error, Model model) {
        if(error != null){
            model.addAttribute("error",true);
        }
        return "/login";
    }

    @PostMapping("/login")
    public String login1() {
        return "redirect:search";
    }



}