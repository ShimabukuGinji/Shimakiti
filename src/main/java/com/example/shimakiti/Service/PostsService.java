package com.example.shimakiti.Service;

import com.example.shimakiti.Repository.PostsRepository;
import com.example.shimakiti.entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostsService {
    @Autowired
    public PostsRepository postsRepository;

    public List<Posts> postsJoinCategory(){
        return postsRepository.postsJoinCategory();
    }
}
