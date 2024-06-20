package com.example.shimakiti.service;

import com.example.shimakiti.repository.BookmarksRepository;
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
public class BookmarkService implements IBookmarkService {

	private final BookmarksRepository bookmarksRepository;

}
