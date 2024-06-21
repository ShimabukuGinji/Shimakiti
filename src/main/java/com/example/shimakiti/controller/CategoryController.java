package com.example.shimakiti.controller;

import com.example.shimakiti.service.CategoryService;
import com.example.shimakiti.service.ShimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.CategoryDetail;
import com.example.shimakiti.service.CategoryService;
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
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String category(Model model){
        var list = new ArrayList<CategoryDetail>();
        for(Categories categories:categoryService.findCategory()){
            CategoryDetail categoryDetail = new CategoryDetail();
            categoryDetail.setId((long) categories.getId());
            categoryDetail.setName(categories.getName());
            categoryDetail.setPosts((long) categoryService.findByCategoryPosts(categories).size());
            list.add(categoryDetail);
        }
        model.addAttribute("categories",list);
        return "category";
    }

    @GetMapping("/categoryDetail/{id}")
    public String categoryDetail(@PathVariable("id")Integer id, Model model){
        var categories = categoryService.findById(id);

        CategoryDetail categoryDetail = new CategoryDetail();
        categoryDetail.setId((long) categories.getId());
        categoryDetail.setName(categories.getName());
        categoryDetail.setPosts((long) categoryService.findByCategoryPosts(categories).size());

        model.addAttribute("category",categoryDetail);
        return "category-detail";
    }

    @GetMapping("/category-edit/{id}")
    public String categoryUpdate(@PathVariable("id")Integer id, Model model){
        model.addAttribute("category",categoryService.findById(id));
        System.out.println(categoryService.findById(id));
        return "category-edit";
    }

    @PostMapping("/category-edit/{id}")
    public String categoryUpdate(@ModelAttribute("category")Categories categories,@PathVariable("id")Integer id,Model model){
        categoryService.updateCategory(id,categories);
        return "redirect:/category";
    }


    @GetMapping("/category-insert")
    public String categoryGET(@ModelAttribute("category")Categories categories){
        return "category-insert";
    }

    @PostMapping("/category-insert")
    public String categoryInsert(@ModelAttribute("category")Categories categories){
        categoryService.addCategory(categories);
        return "redirect:category";
    }

}
