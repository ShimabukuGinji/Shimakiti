package com.example.shimakiti.restController;

import com.example.shimakiti.entity.Likes;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.service.LikeService;
import com.example.shimakiti.service.PostService;
import com.example.shimakiti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikeController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private LikeService likeService;

    @PostMapping("/api/likes/{postId}")
    public ResponseEntity<Void> likePost(@PathVariable int postId, @AuthenticationPrincipal UserDetails userDetails) {
        System.out.println(postId+":");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        likeService.likePost(postId,username);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/likes/delete/{postId}")
    public ResponseEntity<Void> unbookmarkPost(@PathVariable int postId, @AuthenticationPrincipal UserDetails userDetails) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUserName(username);
        Posts post = postService.findById(postId);
        likeService.unlikePost(post, user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/likes")
    public ResponseEntity<List<Likes>> getUserLikes(@AuthenticationPrincipal UserDetails userDetails) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        List<Likes> likes = likeService.getUserLikes(username);
        return ResponseEntity.ok(likes);
    }

    @GetMapping("/api/likes/count/{postId}")
    public ResponseEntity<Integer> getPostLikes(@PathVariable int postId){
        List<Likes> likes = likeService.getPostLikes(postId);
        return ResponseEntity.ok(likes.size());
    }

    @GetMapping("api/likes/status/{postId}")
    public ResponseEntity<Boolean> getUserLikes(@PathVariable int postId, @AuthenticationPrincipal UserDetails userDetails) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isLiked = likeService.islikePost(postId, username);
        return ResponseEntity.ok(isLiked);
    }
}
