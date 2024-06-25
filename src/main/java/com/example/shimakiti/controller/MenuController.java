package com.example.shimakiti.controller;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Notices;
import com.example.shimakiti.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/search")
    public String searchPage(@RequestParam("region") String region,
                             @RequestParam("keyword") String keyword,
                             @RequestParam("category") int category,
                             Model model) {
        List<Categories> categories = menuService.findAll();
        Categories categoryName = menuService.findById(category);
        model.addAttribute("region", region);
        model.addAttribute("keyword", keyword);
        model.addAttribute("categoryParam", categoryName.getName());//選択されたカテゴリ
        model.addAttribute("categories", categories);//全カテゴリ
        System.out.println("\n\n"+category+"\n\n");
        return "search";
    }
}
