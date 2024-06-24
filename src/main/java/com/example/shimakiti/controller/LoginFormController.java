package com.example.shimakiti.controller;

import com.example.shimakiti.entity.NoticeCategory;
import com.example.shimakiti.entity.Notices;
import com.example.shimakiti.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginFormController {
    @GetMapping("/login")
    public String login(@RequestParam(name = "error", required = false)String error, Model model) {
        if(error != null){
            model.addAttribute("error",true);
        }
        return "login";
    }

    @GetMapping("/account/admin")
    public String admin(@ModelAttribute User user) {
        return "user-add";
    }

    @PostMapping("/account/admin")
    public String adminInsert(@ModelAttribute User user) {
        return "user-add";
    }

    @PostMapping("/login")
    public String login1() {
        return "redirect:search";
    }

}