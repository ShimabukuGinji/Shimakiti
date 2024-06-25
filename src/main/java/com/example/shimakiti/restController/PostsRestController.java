package com.example.shimakiti.restController;
import com.example.shimakiti.dto.PostResult;
import com.example.shimakiti.entity.Posts;

import com.example.shimakiti.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class PostsRestController {
    @Autowired
    private PostService postService;


    @GetMapping
    public ResponseEntity<List<Posts>>posts(){
        try {
            var postList = postService.findAllPosts();
            return new ResponseEntity<>(postList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
