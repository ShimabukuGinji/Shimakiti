package com.example.shimakiti.service;

import com.example.shimakiti.repository.CommentsRepository;
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
public class CommentsService implements ICommentsService {

	private final CommentsRepository commentsRepository;

}
