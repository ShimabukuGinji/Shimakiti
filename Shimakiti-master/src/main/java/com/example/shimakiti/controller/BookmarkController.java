package com.example.shimakiti.controller;

import com.example.shimakiti.entity.Bookmark;
import com.example.shimakiti.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping("/{postId}")
    public ResponseEntity<Void> bookmarkPost(@PathVariable Long postId, @AuthenticationPrincipal UserDetails userDetails) {
        bookmarkService.bookmarkPost(postId, userDetails.getUsername());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> unbookmarkPost(@PathVariable Long postId, @AuthenticationPrincipal UserDetails userDetails) {
        bookmarkService.unbookmarkPost(postId, userDetails.getUsername());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Bookmark>> getUserBookmarks(@AuthenticationPrincipal UserDetails userDetails) {
        List<Bookmark> bookmarks = bookmarkService.getUserBookmarks(userDetails.getUsername());
        return ResponseEntity.ok(bookmarks);
    }
}
