package com.example.shimakiti.service;

import com.example.shimakiti.entity.Cities;
import com.example.shimakiti.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ユーザー登録画面Service
 *
 * @author ys-fj
 *
 */
@Service
@RequiredArgsConstructor
public class CitiesService {

    @Autowired
    private final CityRepository cityRepository;

    public List<Cities> findAllCities() {
        return cityRepository.findAll();
    }
}