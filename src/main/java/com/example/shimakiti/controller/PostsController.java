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

    @GetMapping("/menu2")
    public String displayNotices(Model model) {
        List<Posts> posts = postsRepository.postsJoinCategory();
        model.addAttribute("posts", posts);
        return "menu2";
    }
}
