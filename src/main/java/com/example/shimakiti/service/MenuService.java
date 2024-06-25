package com.example.shimakiti.service;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Notices;
import com.example.shimakiti.repository.CategoriesRepository;
import com.example.shimakiti.repository.NoticesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private NoticesRepository noticeRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Notices> findTop3ByOrderByIdDesc(){

        return noticeRepository.findTop3ByOrderByIdDesc();
    }
    public List<Categories> findAll(){
        return categoriesRepository.findAll();
    }

    public Categories findById(int id){return categoriesRepository.findById(id).orElse(null);}
}
