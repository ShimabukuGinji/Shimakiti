package com.example.shimakiti.restController;

import com.example.shimakiti.dto.PostResult;
import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Cities;
import com.example.shimakiti.entity.Posts;

import com.example.shimakiti.entity.User;
import com.example.shimakiti.service.CategoryService;
import com.example.shimakiti.service.CitiesService;
import com.example.shimakiti.service.PostService;
import com.example.shimakiti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SerachPosts {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CitiesService citiesService;



    @GetMapping
    public ResponseEntity<List<PostResult>> getPosts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String region,
            @RequestParam(required = false, defaultValue = "評価順") String order
    ) {
        try {
            List<PostResult> postList;
            switch (order) {
                case "新しい順":
                    postList = postService.searchUpdatedAtDesc(category, keyword, region);
                    break;
                case "古い順":
                    postList = postService.searchUpdatedAtAsc(category, keyword, region);
                    break;
                default:
                    postList = postService.findPosts(category, keyword, region);
            }
            return new ResponseEntity<>(postList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Categories>> getCats(){
        try {
            var catList = categoryService.findCategory();
            return new ResponseEntity<>(catList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/cities")
    public ResponseEntity<List<Cities>> getCities(){
        try {
            var cityList = citiesService.findAllCities();
            return new ResponseEntity<>(cityList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/{postId}")
    public ResponseEntity<Boolean> getUserLikes(@PathVariable int postId, @AuthenticationPrincipal UserDetails userDetails) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isPost = userService.isuserPost(postId, username);
        return ResponseEntity.ok(isPost);
    }

    @GetMapping("/updatedAt/Desc")
    public ResponseEntity<List<PostResult>> updatedAtDesc(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String region){
        try {
            System.out.println(category+":"+keyword+":"+region);
            var postDescList = postService.searchUpdatedAtDesc(category,keyword,region);
            return new ResponseEntity<>(postDescList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/updatedAt/Asc")
    public ResponseEntity<List<PostResult>> updatedAtAsc(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String region){
        try {
            System.out.println(category+":"+keyword+":"+region);
            var postAscList = postService.searchUpdatedAtAsc(category,keyword,region);
            return new ResponseEntity<>(postAscList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}