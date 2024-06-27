package com.example.shimakiti.service;

import com.example.shimakiti.entity.Bookmarks;
import com.example.shimakiti.entity.Comments;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.repository.CommentsRepository;
import com.example.shimakiti.repository.PostRepository;
import com.example.shimakiti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentsRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Comments addComment(int postId, String username, String content) {
        Posts post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        User user = userRepository.findByUsername(username);
        Comments comment = new Comments();
        comment.setContent(content);
        comment.setPost(post);
        comment.setUser(user);
        return commentRepository.save(comment);
    }

    public List<Comments> getCommentsByPost(int postId) {
        Posts post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        return commentRepository.findByPost(post);
    }

    public void commentDelete(int id) {
        commentRepository.deleteById(id);
    }

    public Comments findById(int id) {
        return commentRepository.findById(id).get();
    }

    public void deleteByUser(User user) {
        List<Comments> comments = commentRepository.findByUser(user);
        for (var comment : comments) {
            commentRepository.delete(comment);
        }
    }
}

