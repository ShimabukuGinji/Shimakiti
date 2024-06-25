package com.example.shimakiti.controller;

import com.example.shimakiti.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.CategoryDetail;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/category")
    public String category(Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username.equals("admin")) {
            var list = new ArrayList<CategoryDetail>();
            for(Categories categories:categoryService.findCategory()){
                CategoryDetail categoryDetail = new CategoryDetail();
                categoryDetail.setId(categories.getId());
                categoryDetail.setName(categories.getName());
                categoryDetail.setPosts(categoryService.findByCategoryPosts(categories).size());
                list.add(categoryDetail);
            }
            model.addAttribute("categories",list);
            return "category";
        }
        return "redirect:/menu";
    }

    @GetMapping("/admin/categoryDetail/{id}")
    public String categoryDetail(@PathVariable("id")Integer id, Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username.equals("admin")) {
            var categories = categoryService.findById(id);
            CategoryDetail categoryDetail = new CategoryDetail();
            categoryDetail.setId(categories.getId());
            categoryDetail.setName(categories.getName());
            categoryDetail.setPosts((long) categoryService.findByCategoryPosts(categories).size());
            model.addAttribute("category",categoryDetail);
            return "category-detail";
        }
        return "redirect:/menu";
    }

    @GetMapping("/admin/category-edit/{id}")
    public String categoryUpdate(@PathVariable("id")Integer id, Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username.equals("admin")) {
            model.addAttribute("category",categoryService.findById(id));
            System.out.println(categoryService.findById(id));
            return "category-edit";
        }
        return "redirect:/menu";
    }

    @PostMapping("/admin/category-edit/{id}")
    public String categoryUpdate(@ModelAttribute("category")Categories categories,@PathVariable("id")Integer id,Model model){
        categoryService.updateCategory(id,categories);
        return "redirect:/admin/category";
    }


    @GetMapping("/admin/category-insert")
    public String categoryGET(@ModelAttribute("category")Categories categories){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username.equals("admin")) {
            return "category-insert";
        }
        return "redirect:/menu";
    }

    @PostMapping("/admin/category-insert")
    public String categoryInsert(@ModelAttribute("category")Categories categories){
        categoryService.addCategory(categories);
        return "redirect:/admin/category";
    }
}