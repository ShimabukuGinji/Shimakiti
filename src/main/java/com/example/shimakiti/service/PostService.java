package com.example.shimakiti.service;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.repository.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Posts> findAllPosts(){return postRepository.findAll();}

    public List<Posts> findByCategoriesPosts(Categories categories){return postRepository.findByCategories(categories);}
}
