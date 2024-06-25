package com.example.shimakiti.restController;

import com.example.shimakiti.entity.Cities;
import com.example.shimakiti.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class CitiesRestController {

    /** 市町村情報テーブルDAO */
    @Autowired
    CityRepository cityRepository;

    @GetMapping("find-by-id")
    public ResponseEntity<Cities> course(@RequestParam(name = "addressName")String addressName){
        var city = cityRepository.findByName(addressName);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}