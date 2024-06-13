package com.example.shimakiti.controller;

import com.example.shimakiti.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/{postId}/like")
    public ResponseEntity<Void> likePost(@PathVariable Long postId, @AuthenticationPrincipal UserDetails userDetails) {
        likeService.likePost(postId, userDetails.getUsername());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{postId}/like")
    public ResponseEntity<Void> unlikePost(@PathVariable Long postId, @AuthenticationPrincipal UserDetails userDetails) {
        likeService.unlikePost(postId, userDetails.getUsername());
        return ResponseEntity.ok().build();
    }
}