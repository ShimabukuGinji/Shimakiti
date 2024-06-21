package com.example.shimakiti.controller;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.CategoryDetail;
import com.example.shimakiti.service.CategoriesService;
import com.example.shimakiti.service.ShimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class ShimaContoroller {

    @Autowired
    private ShimaService shimaService;

    @GetMapping("/category")
    public String category(Model model){
        var list = new ArrayList<CategoryDetail>();
        for(Categories categories:shimaService.findCategory()){
            CategoryDetail categoryDetail = new CategoryDetail();
            categoryDetail.setId(categories.getId());
            categoryDetail.setName(categories.getName());
            categoryDetail.setPosts((long) shimaService.findByCategoryPosts(categories).size());
            list.add(categoryDetail);
        }
        model.addAttribute("categories",list);
        return "category";
    }

    @GetMapping("/categoryDetail/{id}")
    public String categoryDetail(@PathVariable("id")Long id, Model model){
        var categories = shimaService.findById(id);

        CategoryDetail categoryDetail = new CategoryDetail();
        categoryDetail.setId(categories.getId());
        categoryDetail.setName(categories.getName());
        categoryDetail.setPosts((long) shimaService.findByCategoryPosts(categories).size());

        model.addAttribute("category",categoryDetail);
        return "category-detail";
    }

    @GetMapping("/category-edit/{id}")
    public String categoryUpdate(@PathVariable("id")Long id, Model model){
        model.addAttribute("category",shimaService.findById(id));
        System.out.println(shimaService.findById(id));
        return "category-edit";
    }

    @PostMapping("/category-edit/{id}")
    public String categoryUpdate(@ModelAttribute("category")Categories categories,@PathVariable("id")Long id,Model model){
        shimaService.updateCategory(id,categories);
        return "redirect:/category";
    }


    @GetMapping("/category-insert")
    public String categoryGET(@ModelAttribute("category")Categories categories){
        return "category-insert";
    }

    @PostMapping("/category-insert")
    public String categoryInsert(@ModelAttribute("category")Categories categories){
        shimaService.addCategory(categories);
        return "redirect:category";
    }

}
