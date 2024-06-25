package com.example.shimakiti.controller;

import com.example.shimakiti.entity.Comments;
import com.example.shimakiti.service.CommentService;
import com.example.shimakiti.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @PostMapping("/add/{postId}")
    public String addComment(@PathVariable int postId, @RequestParam String content, @AuthenticationPrincipal UserDetails userDetails) {
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Content must not be empty");
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        commentService.addComment(postId, username, content);
        return "redirect:/posts/detail/" + postId;
    }

    @GetMapping("/post/{postId}")
    public String getCommentsByPost(@PathVariable int postId, Model model) {
        List<Comments> comments = commentService.getCommentsByPost(postId);
        System.out.println("comments.get(0).getContent()");
        System.out.println(comments.get(0).getContent());
        model.addAttribute("comments", comments);
        return "comments";
    }
}
