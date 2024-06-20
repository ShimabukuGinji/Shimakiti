package com.example.shimakiti.controller;

import com.example.shimakiti.Repository.CategoriesRepository;
import com.example.shimakiti.Repository.PostsRepository;
import com.example.shimakiti.Repository.UsersRepository;
import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Notices;
import com.example.shimakiti.entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class PostsController {
    @Autowired
    public PostsRepository postsRepository;
    @Autowired
    public CategoriesRepository categoriesRepository;
    @Autowired
    public UsersRepository usersRepository;

    @GetMapping("/menu2")
    public String displayNotices(Model model) {
        System.out.println("posts");
        List<Posts> posts = postsRepository.postsJoinCategory();
        model.addAttribute("categories",categoriesRepository.findAll());
        model.addAttribute("users",usersRepository.findAll());
        model.addAttribute("posts", posts);
        System.out.println(posts);
        System.out.println("posts");
        return "menu2";
    }
}
