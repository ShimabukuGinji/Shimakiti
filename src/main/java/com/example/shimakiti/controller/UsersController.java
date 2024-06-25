package com.example.shimakiti.controller;

import com.example.shimakiti.From.ProfileForm;
import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.service.MenuService;
import com.example.shimakiti.service.NoticeCategoryService;
import com.example.shimakiti.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UsersController {

    @Autowired
    UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    NoticeCategoryService noticeCategoryService;

    @GetMapping("/my-page")
    public String profile(Model model) throws IOException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userService.findByUserName(username);
        var profile = userService.profileResult(user);
        model.addAttribute("profile", profile);
        model.addAttribute("myPage", 1);
        return "profile";
    }

    @GetMapping("/my-page/edit")
    public String profileEdit(@ModelAttribute("profileForm") ProfileForm form, Model model) throws IOException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userService.findByUserName(username);
        var profile = userService.profileResult(user);
        model.addAttribute("profileForm", profile);
        model.addAttribute("myPage", 1);
        return "profile-edit";
    }

    @PostMapping("/my-page/edit")
    public String profileUpdate(@Validated @ModelAttribute("profileForm") ProfileForm form, BindingResult bindingResult, Model model) throws IOException {
        if(bindingResult.hasErrors()) {
            return "profile-edit";
        }
        userService.update(form);
        return "redirect:/my-page";
    }

    @GetMapping("/profile/{userId}")
    public String profile(@PathVariable("userId") int userId, Model model) throws IOException {
        var user = userService.findById(userId);
        var profile = userService.profileResult(user);
        model.addAttribute("profile", profile);
        model.addAttribute("myPage", 2);
        return "profile";
    }

    @GetMapping("/admin")
    public String admin(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username.equals("admin")) {
            return "admin";
        }
        return "redirect:/menu";
    }

    @GetMapping("/bookmark")
    public String searchPage(Model model) {
        List<Categories> categories = menuService.findAll();
        model.addAttribute("categories", categories);//全カテゴリ
        return "search";
    }
}