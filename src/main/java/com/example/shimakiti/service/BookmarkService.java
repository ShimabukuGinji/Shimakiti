package com.example.shimakiti.service;

import com.example.shimakiti.entity.Bookmarks;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.repository.BookmarkRepository;
import com.example.shimakiti.repository.PostRepository;
import com.example.shimakiti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public void bookmarkPost(int postId, String username) {
        User user = userRepository.findByUsername(username);
        Posts post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        if (!bookmarkRepository.existsByPostAndUser(post, user)) {
            Bookmarks bookmark = new Bookmarks(post, user);
            bookmarkRepository.save(bookmark);
        }
    }

    public void unbookmarkPost(Posts post, User user) {
        Bookmarks bookmark = bookmarkRepository.findByPostAndUser(post, user);
        bookmarkRepository.delete(bookmark);
    }

    public List<Bookmarks> getUserBookmarks(String username) {
        User user = userRepository.findByUsername(username);
        return bookmarkRepository.findByUser(user);
    }

    public boolean isPostBookmarkedByUser(int postId, String username) {
        User user = userRepository.findByUsername(username);
        Posts post = postRepository.findById(postId).orElse(null);
        Bookmarks bookmark = bookmarkRepository.findByPostAndUser(post, user);
        return bookmark != null;
    }

    public void deleteByUser(User user) {
        List<Bookmarks> bookmarks = bookmarkRepository.findByUser(user);
        for (var bookmark : bookmarks) {
            bookmarkRepository.delete(bookmark);
        }
    }
}
