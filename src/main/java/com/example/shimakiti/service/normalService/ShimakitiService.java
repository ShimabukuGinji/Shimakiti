package com.example.shimakiti.service.normalService;

import com.example.shimakiti.entity.Posts;
//import com.example.shimakiti.entity.SearchForm;
import com.example.shimakiti.repository.normalRepository.ShimakitiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShimakitiService implements IShimakitiService {

    @Autowired
    ShimakitiRepository shimakitiRepository;

    @Override
    public List<Posts> findAllPosts(){
        return shimakitiRepository.findAllPosts();
    }

//    @Override
//    public List<Posts> search(SearchForm searchForm) { return shimakitiRepository.search(searchForm); }
}
