package com.example.shimakiti.service;

import com.example.shimakiti.entity.CityInfo;
import com.example.shimakiti.repository.CityInfoRepository;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

/**
 * ユーザー登録画面Service
 * 
 * @author ys-fj
 *
 */
@Service
@RequiredArgsConstructor
public class CityService implements ICityService {

	@Autowired
	private CityInfoRepository cityRepository;

}
