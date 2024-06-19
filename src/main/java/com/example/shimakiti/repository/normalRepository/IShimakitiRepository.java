package com.example.shimakiti.repository.normalRepository;

//import com.example.shimakiti.entity.SearchForm;
import com.example.shimakiti.entity.void_data.Categories11111;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.void_data.Posts11111;

import java.util.List;

public interface IShimakitiRepository {

    List<Posts> findAllPosts();

    Posts11111 findByIdPosts(int id);
    Categories11111 findByIdCategory(int id);

//    List<Posts> search(SearchForm searchForm);
}
