package com.example.shimakiti.controller;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Controller
public class loginController {
    @Autowired
    private UserService userService;

//    @GetMapping("login")
//    public String login(){
//        List<User> user1 = userService.findAllUsers();
//        for(var a:user1) {
//            System.out.println(a.getId()+","+a.getUsername()+","+a.getCreated_at()+","+a.getUpdated_at());
//        }System.out.println(1);
//        return "login";
//    }

    @GetMapping("admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("post-list")
    public String menu(){
        return "post-list";
    }

    @GetMapping("pirate")
    public String pirate(){
        return "pirate";
    }

    @GetMapping("bookmark")
    public String bookemark(){return "bookmark";}

    @GetMapping("bookmark2")
    public String bookemark2(){return "bookmark2";}

    @GetMapping("cheet")
    public String cheet(){return "cheet";}

    @GetMapping("BookmarkButton")
    public String BookmarkButton(){return "BookmarkButton";}
}