package com.example.shimakiti.controller;

import com.example.shimakiti.service.ShimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    ShimaService shimaService;

    @GetMapping("/home")
    public String init(Model model) {
        model.addAttribute("loginusers", shimaService.findAllUser());
        return "home";
    }
}