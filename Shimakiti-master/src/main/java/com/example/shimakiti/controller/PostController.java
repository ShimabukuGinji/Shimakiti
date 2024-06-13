package com.example.shimakiti.controller;


import com.example.shimakiti.entity.Post;
import com.example.shimakiti.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> addPost(@RequestBody Post post, @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(postService.addPost(post, userDetails.getUsername()));
    }
}
