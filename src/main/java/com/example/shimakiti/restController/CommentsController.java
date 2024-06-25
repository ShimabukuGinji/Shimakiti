package com.example.shimakiti.restController;

import com.example.shimakiti.entity.Comments;
import com.example.shimakiti.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{postId}")
    public ResponseEntity<Comments> addComment(@PathVariable int postId, @RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Comments comment = commentService.addComment(postId, username, content);
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<Comments>> getCommentsByPost(@PathVariable int postId) {
        List<Comments> comments = commentService.getCommentsByPost(postId);
        return ResponseEntity.ok(comments);
    }
}