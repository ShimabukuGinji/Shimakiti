package com.example.shimakiti.Service;

import com.example.shimakiti.Repository.CategoriesRepository;
import com.example.shimakiti.Repository.NoticeRepository;
import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Notices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private NoticeRepository noticeRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Notices> findTop3ByOrderByIdDesc(){
        return noticeRepository.findTop3ByOrderByIdDesc();
    }
    public List<Categories> findAll(){
        return categoriesRepository.findAll();
    }

}

//SELECT * FROM categories;