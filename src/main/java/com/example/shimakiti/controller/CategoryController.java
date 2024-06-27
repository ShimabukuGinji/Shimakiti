package com.example.shimakiti.controller;

import com.example.shimakiti.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @GetMapping("/admin/categoryDetail/{id}")
    public String categoryDetail(@PathVariable("id")Integer id, Model model){
        var categories = categoryService.findById(id);
        CategoryDetail categoryDetail = new CategoryDetail();
        categoryDetail.setId(categories.getId());
        categoryDetail.setName(categories.getName());
        categoryDetail.setPosts((long) categoryService.findByCategoryPosts(categories).size());
        model.addAttribute("category",categoryDetail);
        return "category-detail";
    }

    @GetMapping("/admin/category-edit/{id}")
    public String categoryUpdate(@ModelAttribute("category") Categories categories, @PathVariable("id")Integer id, Model model){
        model.addAttribute("category",categoryService.findById(id));
        System.out.println(categoryService.findById(id));
        return "category-edit";
    }

    @PostMapping("/admin/category-edit/{id}")
    public String categoryUpdate(@Validated @ModelAttribute("category") Categories categories, BindingResult bindingResult, @PathVariable("id")Integer id, Model model){
        if (bindingResult.hasErrors()) {
            return "category-edit";
        }
        categoryService.updateCategory(id,categories);
        return "redirect:/admin/category";
    }


    @GetMapping("/admin/category-insert")
    public String categoryGET(@ModelAttribute("category")Categories categories){

        return "category-insert";
    }

    @PostMapping("/admin/category-insert")
    public String categoryInsert(@Validated @ModelAttribute("category") Categories categories, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "category-insert";
        }
        categoryService.addCategory(categories);
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") Integer id){
        categoryService.deleteCategory(id);
        return "redirect:/admin/category";
    }
}