package com.example.shimakiti.service;

import com.example.shimakiti.entity.Bookmark;
import com.example.shimakiti.entity.Post;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.repository.BookmarkRepository;
import com.example.shimakiti.repository.PostRepository;
import com.example.shimakiti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public void bookmarkPost(Long postId, String username) {
        User user = userRepository.findByUsername(username);
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        if (!bookmarkRepository.existsByPostAndUser(post, user)) {
            Bookmark bookmark = new Bookmark(post, user);
            bookmarkRepository.save(bookmark);
        }
    }

    public void unbookmarkPost(Long postId, String username) {
        User user = userRepository.findByUsername(username);
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        bookmarkRepository.deleteByPostAndUser(post, user);
    }

    public List<Bookmark> getUserBookmarks(String username) {
        User user = userRepository.findByUsername(username);
        return bookmarkRepository.findByUser(user);
    }
}
