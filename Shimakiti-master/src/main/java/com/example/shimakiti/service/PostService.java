package com.example.shimakiti.service;

import com.example.shimakiti.entity.Post;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.repository.PostRepository;
import com.example.shimakiti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Post addPost(Post post, String username) {
        User user = userRepository.findByUsername(username);
        post.setUser(user);
        return postRepository.save(post);
    }
}
