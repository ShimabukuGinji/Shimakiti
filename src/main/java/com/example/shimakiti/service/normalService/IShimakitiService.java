package com.example.shimakiti.service.normalService;

import com.example.shimakiti.entity.Posts;
//import com.example.shimakiti.entity.SearchForm;

import java.util.List;

public interface IShimakitiService {
    List<Posts> findAllPosts();

//    List<Posts> search(SearchForm searchForm);
}
