package com.example.shimakiti.controller;

import com.example.shimakiti.Service.MenuService;
import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Notices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public String displayNotices(Model model) {
        List<Notices> notices = menuService.findTop3ByOrderByIdDesc();
        List<Categories> categories = menuService.findAll();
        model.addAttribute("notices", notices);
        model.addAttribute( "categories",categories);
        return "menu";
    }

    @GetMapping("/menu2")
    public String menu2() {
        return "menu2";
    }

    @GetMapping("/search")
    public String searchPage(@RequestParam("location") String location,
                             @RequestParam("keyword") String keyword,
                             @RequestParam("category") int category,
                             Model model) {
        List<Categories> categories = menuService.findAll();
        model.addAttribute("location", location);
        model.addAttribute("keyword", keyword);
        model.addAttribute("categoryParam", category);//選択されたカテゴリ
        model.addAttribute("categories", categories);//全カテゴリ
        System.out.println("\n\n"+category+"\n\n");
        return "search";
    }
}

