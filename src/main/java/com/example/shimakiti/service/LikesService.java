package com.example.shimakiti.service;

import com.example.shimakiti.repository.LikesRepository;
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
public class LikesService implements ILikesService {

	private final LikesRepository likesRepository;

}
