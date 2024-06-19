package com.example.shimakiti.repository.normalRepository;

//import com.example.shimakiti.entity.SearchForm;
import com.example.shimakiti.entity.void_data.Categories11111;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.void_data.Posts11111;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShimakitiRepository implements IShimakitiRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override  //postsテーブルをレコードクラスとして格納する
    public List<Posts> findAllPosts(){
        return jdbcTemplate.query("SELECT * FROM posts",new DataClassRowMapper<>(Posts.class));
    }

    @Override
    public Posts11111 findByIdPosts(int id){
        var param = new MapSqlParameterSource();
        param.addValue("id",id);
        return jdbcTemplate.queryForObject("SELECT * FROM WHERE id = :id",param,new DataClassRowMapper<>(Posts11111.class));
    }

    @Override
    public Categories11111 findByIdCategory(int id){
        var param = new MapSqlParameterSource();
        param.addValue("id",id);
        return jdbcTemplate.queryForObject("SELECT * FROM WHERE id = :id",param,new DataClassRowMapper<>(Categories11111.class));
    }

//    @Override
//    public List<Posts> search(SearchForm searchForm) {
//        var param = new MapSqlParameterSource();
//        param.addValue("category_id",searchForm.getCategories_id());
//        param.addValue("cities_id",searchForm.getCities_id());
//        param.addValue("keyword","%" + searchForm.getKeyword() + "%");
//        return jdbcTemplate.query("SELECT * FROM WHERE category_id = :category_id AND cities_id = :cities_id AND LIKE ",param,new DataClassRowMapper<>(Posts.class));
//    }
}
