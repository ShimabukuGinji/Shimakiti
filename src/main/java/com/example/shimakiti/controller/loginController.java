package com.example.shimakiti.controller;

import com.example.shimakiti.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class loginController {

    /** ブックマーク情報テーブルDAO */
    private final BookmarksRepository bookmarksRepository;

    /** カテゴリー情報テーブルDAO */
    private final CategoriesRepository categoryRepository;

    /** 市町村情報テーブルDAO */
    private final CitiesRepository cityRepository;

    /** コメント情報テーブルDAO */
    private final CommentsRepository commentsRepository;

    /** いいね情報テーブルDAO */
    private final LikesRepository likesRepository;

    /** お知らせカテゴリー情報テーブルDAO */
    private final NoticeCategoryRepository noticeCategoryRepository;

    /** お知らせ情報テーブルDAO */
    private final NoticeRepository noticeRepository;

    /** 投稿情報テーブルDAO */
    private final PostsRepository postsRepository;

    /** ユーザー情報テーブルDAO */
    private final UserRepository userRepository;

    @GetMapping("/index")
    public String index() {
        System.out.println(bookmarksRepository.findAll());
        System.out.println(categoryRepository.findAll());
        System.out.println(cityRepository.findAll());
        System.out.println(commentsRepository.findAll());
        System.out.println(likesRepository.findAll());
        System.out.println(noticeCategoryRepository.findAll());
        System.out.println(noticeRepository.findAll());
        System.out.println(postsRepository.findAll());
        System.out.println(userRepository.findAll());
        return "admin";
    }

}