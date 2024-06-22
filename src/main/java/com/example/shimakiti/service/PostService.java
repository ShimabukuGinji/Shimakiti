package com.example.shimakiti.service;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.repository.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Posts> findAllPosts(){return postRepository.findAll();}

    public List<Posts> findByCategoriesPosts(Categories categories){
        return postRepository.findByCategories(categories);}


    public List<Posts> findPosts(String category, String keyword, String region) {
        if (!StringUtils.hasText(category) && !StringUtils.hasText(keyword) && !StringUtils.hasText(region)) {
            return postRepository.findAll();
        }
        return postRepository.findPostsByCriteria(category, keyword, region);
    }
}
