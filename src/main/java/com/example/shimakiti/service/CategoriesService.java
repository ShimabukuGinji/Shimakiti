package com.example.shimakiti.service;

import com.example.shimakiti.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriesService implements ICategoriesService{

    @Autowired
    private ICategoryRepository iCategoryRepository;


}
