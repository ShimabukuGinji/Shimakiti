package com.example.shimakiti.controller;

import com.example.shimakiti.From.ProfileForm;
import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.service.*;
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

    @Autowired
    PostService postService;

    @Autowired
    BookmarkService bookmarkService;

    @Autowired
    LikeService likeService;

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
        model.addAttribute("icon", profile.getProfilePicture());
        model.addAttribute("profileForm", profile);
        model.addAttribute("myPage", 1);
        return "profile-edit";
    }

    @PostMapping("/my-page/edit")
    public String profileUpdate(@Validated @ModelAttribute("profileForm") ProfileForm form, BindingResult bindingResult, Model model) throws IOException {
        if(bindingResult.hasErrors()) {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            var user = userService.findByUserName(username);
            var profile = userService.profileResult(user);
            model.addAttribute("icon", profile.getProfilePicture());
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
        return "admin";
    }

    @GetMapping("/admin/users")
    public String user(Model model) {
        model.addAttribute("users",userService.findAllUsers());
        return "user-list";
    }

    @GetMapping("/admin/user-insert")
    public String userInsert(@ModelAttribute("user") User user) {
        return "user-insert";
    }

    @GetMapping("/admin/userDetail/{id}")
    public String userDetail(@PathVariable("id")Integer id,Model model) {
        model.addAttribute("user",userService.findById(id));
        return "user-detail";
    }

    @GetMapping("/admin/user-edit/{id}")
    public String userEdit(@PathVariable("id")Integer id,Model model) {
        model.addAttribute("user",userService.findById(id));
        return "user-edit";
    }

    @PostMapping("/admin/user-edit")
    public String userEditPost(@ModelAttribute("user")User user) {
        var userDate = userService.findById(user.getId());
        userDate.setName(user.getName());
        userDate.setPassword(user.getPassword());
        userService.updateUser(userDate);
        return "redirect:users";
    }

    @GetMapping("/deleteUser/{id}")
    public String userDelete(@PathVariable("id") int id) {
        var posts = postService.findByUser(userService.findById(id));
        for (var post : posts) {
            postService.delete(post.getId());
        }
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/deleteMyAcc/{id}")
    public String userDeleteMyAccount(@PathVariable("id") int id) {
        var posts = postService.findByUser(userService.findById(id));
        for (var post : posts) {
            postService.delete(post.getId());
        }
        userService.deleteUserById(id);
        return "redirect:/login";
    }

    @GetMapping("/bookmarks")
    public String searchPage(Model model) {
        List<Categories> categories = menuService.findAll();
        model.addAttribute("categories", categories);//全カテゴリ
        return "bookmark";
    }
}