package com.example.shimakiti.restController;

import com.example.shimakiti.entity.Bookmarks;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.service.BookmarkService;
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
public class BookmarkController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping("/api/bookmarks/{postId}")
    public ResponseEntity<Void> bookmarkPost(@PathVariable int postId, @AuthenticationPrincipal UserDetails userDetails) {
        System.out.println(postId+":");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        bookmarkService.bookmarkPost(postId,username);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/bookmarks/delete/{postId}")
    public ResponseEntity<Void> unbookmarkPost(@PathVariable int postId, @AuthenticationPrincipal UserDetails userDetails) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUserName(username);
        Posts post = postService.findById(postId);
        bookmarkService.unbookmarkPost(post, user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/bookmarks")
    public ResponseEntity<List<Bookmarks>> getUserBookmarks(@AuthenticationPrincipal UserDetails userDetails) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        List<Bookmarks> bookmarks = bookmarkService.getUserBookmarks(username);
        return ResponseEntity.ok(bookmarks);
    }

    @GetMapping("/api/bookmarks/status/{postId}")
    public ResponseEntity<Boolean> getUserBookmarks(@PathVariable int postId, @AuthenticationPrincipal UserDetails userDetails) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isBookmarked = bookmarkService.isPostBookmarkedByUser(postId, username);
        return ResponseEntity.ok(isBookmarked);
    }
}
