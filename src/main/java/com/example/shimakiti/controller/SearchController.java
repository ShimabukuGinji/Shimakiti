package com.example.shimakiti.controller;

//import com.example.shimakiti.entity.SearchForm;

//import com.example.shimakiti.service.ShimaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//@Controller
//public class SearchController {
//    @Autowired
//    private ShimaService shimaService;
//
//
//    @GetMapping("/search")
//    public String search(Model model){
//        model.addAttribute("posts",shimaService.findAll());
//        model.addAttribute("categories",shimaService.findCategory());
//        model.addAttribute("cities",shimaService.findCity());
//        return "search";
//    }
//
//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }
//}
