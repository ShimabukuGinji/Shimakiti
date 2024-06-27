package com.example.shimakiti.controller;

import com.example.shimakiti.From.PostForm;
import com.example.shimakiti.repository.CategoriesRepository;
import com.example.shimakiti.repository.CityRepository;
import com.example.shimakiti.repository.PostRepository;
import com.example.shimakiti.repository.UserRepository;
import com.example.shimakiti.service.CommentService;
import com.example.shimakiti.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

/**
 * ユーザー登録画面Controller
 *
 * @author ys-fj
 *
 */
@Controller
@RequiredArgsConstructor
public class PostController {

    /** 投稿画面Service */
    private final PostService postservice;

    /** 投稿情報テーブルDAO */
    private final PostRepository postRepository;

    /** カテゴリー情報テーブルDAO */
    private final CategoriesRepository categoryRepository;

    /** 市町村情報テーブルDAO */
    private final CityRepository cityRepository;

    /** ユーザー情報テーブルDAO */
    private final UserRepository userRepository;


    private final CommentService commentService;

    /**
     * 初期表示
     *
     * @param model モデル
     * @param form フォーム
     * @return 画面名
     */
    @GetMapping("/posts")
    public String view(@ModelAttribute("postForm") PostForm form, Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("cities", cityRepository.findAll());
        return "post-insert";
    }

    /**
     * ユーザー登録
     *
     * @param form フォーム
     * @return リダイレクト先
     * @throws IOException
     */
    @PostMapping("/posts")
    public String post(@Validated @ModelAttribute("postForm") PostForm form, BindingResult bindingResult, Model model) throws IOException {
        if(bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("cities", cityRepository.findAll());
            return "post-insert";
        }
        postservice.insert(form);
        return "redirect:/search?region=&keyword=&category=0";
    }

    /**
     * 詳細画面
     *
     * @param model モデル
     * @return 画面名
     */
    @GetMapping("/posts/detail/{postID}")
    public String detail(@PathVariable("postID") int postId, Model model) throws IOException {
        var post = postservice.postResult(postId);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userRepository.findByUsername(username);
        if (post.isPresent()) {
            model.addAttribute("user", user);
            model.addAttribute("post",post.get());
            model.addAttribute("comments", commentService.getCommentsByPost(postId));
            System.out.println(post.get().getCreated_at());
            return "post-detail";
        }
        return "redirect:/posts";
    }

    /**
     * 詳細画面
     *
     * @param model モデル
     * @return 画面名
     */
    @GetMapping("/posts/edit/{postID}")
    public String edit(@PathVariable("postID") int postId, @ModelAttribute("postForm") PostForm form, Model model) throws IOException {
        var post = postservice.postResult(postId);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userRepository.findByUsername(username);
        if (post.isPresent() && (post.get().getUsers().getId() == user.getId() || user.getRole() == 1)) {
            if (post.get().getUsers() == user) {
                model.addAttribute("categories", categoryRepository.findAll());
                model.addAttribute("cities", cityRepository.findAll());
                model.addAttribute("postForm",post.get());
                return "post-edit";
            }
            return "redirect:/posts/detail/" + postId;
        }
        return "redirect:/search?region=&keyword=&category=0";
    }

    @PostMapping("/posts/edit/{postID}")
    public String update(@PathVariable("postID") int postId, @Validated @ModelAttribute("postForm") PostForm form, BindingResult bindingResult, Model model) throws IOException {
        if(bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("cities", cityRepository.findAll());
            return "post-edit";
        }
        postservice.update(form, postId);
        return "redirect:/posts/detail/" + postId;
    }

    @PostMapping("/posts/delete/{postID}")
    public String delete(@PathVariable("postID") int postId) throws IOException {
        postservice.delete(postId);
        return "redirect:/search?region=&keyword=&category=0";
    }
}