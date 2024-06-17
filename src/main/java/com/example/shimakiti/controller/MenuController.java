package com.example.shimakiti.controller;

import com.example.shimakiti.Service.MenuService;
import com.example.shimakiti.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

//    @GetMapping("/displayNotices")
//    public List<Notice> displayNotices() {
//        List<Notice> notices = menuService.getAllNotices();
//        return notices;
//    }
    @GetMapping("/menu")
    public List<Notice> displayNotices() {
        List<Notice> notices = menuService.getAllNotices();
        return notices;
    }
}

