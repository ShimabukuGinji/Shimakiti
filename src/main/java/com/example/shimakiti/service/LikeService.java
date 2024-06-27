package com.example.shimakiti.service;

import com.example.shimakiti.entity.Bookmarks;
import com.example.shimakiti.entity.Likes;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.repository.BookmarkRepository;
import com.example.shimakiti.repository.LikesRepository;
import com.example.shimakiti.repository.PostRepository;
import com.example.shimakiti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public void likePost(int postId, String username) {
        User user = userRepository.findByUsername(username);
        Posts post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        if (!likesRepository.existsByPostAndUser(post, user)) {
            Likes like = new Likes(post, user);
            likesRepository.save(like);
        }
    }

    public void unlikePost(Posts post, User user) {
        Likes like = likesRepository.findByPostAndUser(post, user);
        likesRepository.delete(like);
    }

    public List<Likes> getUserLikes(String username) {
        User user = userRepository.findByUsername(username);
        return likesRepository.findByUser(user);
    }

    public List<Likes> getPostLikes(int postId) {
        Posts post = postRepository.findById(postId).get();
        return likesRepository.findByPost(post);
    }

    public boolean islikePost(int postId, String username) {
        User user = userRepository.findByUsername(username);
        Posts post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        Likes likes = likesRepository.findByPostAndUser(post,user);
        return likes != null;
    }

    public void deleteByUser(User user) {
        List<Likes> likes = likesRepository.findByUser(user);
        for (var like : likes) {
            likesRepository.delete(like);
        }
    }
}
