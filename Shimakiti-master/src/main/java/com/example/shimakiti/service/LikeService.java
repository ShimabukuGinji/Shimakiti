package com.example.shimakiti.service;

import com.example.shimakiti.entity.Like;
import com.example.shimakiti.entity.Post;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.repository.LikeRepository;
import com.example.shimakiti.repository.PostRepository;
import com.example.shimakiti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public void likePost(Long postId, String username) {
        User user = userRepository.findByUsername(username);
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        if (!likeRepository.existsByPostAndUser(post, user)) {
            Like like = new Like(post, user);
            likeRepository.save(like);
        }
    }

    public void unlikePost(Long postId, String username) {
        User user = userRepository.findByUsername(username);
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        likeRepository.deleteByPostAndUser(post, user);
    }
}
