package com.example.shimakiti.controller;

import com.example.shimakiti.entity.Comments;
import com.example.shimakiti.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{postId}")
    public ResponseEntity<Comments> addComment(@PathVariable int postId, @RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
        Comments comment = commentService.addComment(postId, userDetails.getUsername(), content);
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<Comments>> getCommentsByPost(@PathVariable int postId) {
        List<Comments> comments = commentService.getCommentsByPost(postId);
        return ResponseEntity.ok(comments);
    }
}

