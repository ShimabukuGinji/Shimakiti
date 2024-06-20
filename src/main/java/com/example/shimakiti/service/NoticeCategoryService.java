package com.example.shimakiti.service;

import com.example.shimakiti.repository.NoticeCategoryRepository;
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
public class NoticeCategoryService implements INoticeCategoryService {

	private final NoticeCategoryRepository noticeCategoryRepository;

}
