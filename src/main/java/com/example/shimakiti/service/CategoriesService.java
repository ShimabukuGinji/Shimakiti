package com.example.shimakiti.service;

import com.example.shimakiti.repository.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * ユーザー登録画面Service
 * 
 * @author ys-fj
 *
 */
@Service
@RequiredArgsConstructor
public class CategoriesService implements ICategoriesService {

	private final CategoriesRepository categoriesRepository;

}
