package com.example.shimakiti.controller;

import com.example.shimakiti.dto.PostResult;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.repository.PostRepository;
import com.example.shimakiti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginFormController {

    @Autowired
    UserService userService;

    @Autowired
    PostRepository postRepository;

    @GetMapping("/login")
    public String login(@RequestParam(name = "error", required = false)String error, Model model) {
        if(error != null){
            model.addAttribute("error",true);
        }
        return "login";
    }

    @GetMapping("/account/admin")
    public String admin(@ModelAttribute("userForm") User user) {
        return "user-add";
    }

    @PostMapping("/account/admin")
    public String adminInsert(@Validated @ModelAttribute("userForm") User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "user-add";
        }
        try {
            userService.insert(user);
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("DuplicationError", "このIDは使用されています");
            return "user-add";
        }
        return "login";
    }

}