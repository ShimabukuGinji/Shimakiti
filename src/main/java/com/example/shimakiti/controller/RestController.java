package com.example.shimakiti.controller;

import com.example.shimakiti.entity.CityInfo;
import com.example.shimakiti.repository.CityInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    /** 市町村情報テーブルDAO */
    @Autowired
    CityInfoRepository cityRepository;

    @GetMapping("find-by-id")
    public ResponseEntity<CityInfo> course(@RequestParam(name = "addressName")String addressName){
        var city = cityRepository.findByName(addressName);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}