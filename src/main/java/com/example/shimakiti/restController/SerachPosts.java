package com.example.shimakiti.restController;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Cities;
import com.example.shimakiti.entity.Posts;

import com.example.shimakiti.service.CategoryService;
import com.example.shimakiti.service.CitiesService;
import com.example.shimakiti.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SerachPosts {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CitiesService citiesService;

//    @GetMapping
//    public ResponseEntity<List<Posts>>posts(){
//        try {
//            var postList = postService.findByCategoriesPosts();
//            return new ResponseEntity<>(postList, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }


    @GetMapping
    public ResponseEntity<List<Posts>> getPosts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String region
    ) {
        try{
            System.out.println(category+":"+keyword+":"+region);
            var postList = postService.findPosts(category, keyword, region);
            return new ResponseEntity<>(postList, HttpStatus.OK);
        }catch (Exception e){
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

}
