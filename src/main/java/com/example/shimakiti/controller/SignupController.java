package com.example.shimakiti.controller;

import com.example.shimakiti.From.PostForm;
import com.example.shimakiti.From.SignupForm;
import com.example.shimakiti.service.PostService;
import com.example.shimakiti.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
public class SignupController {

	/** ユーザー登録画面Service */
	private final PostService postservice;

	/**
	 * 初期表示
	 * 
	 * @param model モデル
	 * @param form フォーム
	 * @return 画面名
	 */
	@GetMapping("/register")
	public String view(Model model, PostForm form) {
		return "register";
	}

	/**
	 * ユーザー登録
	 * 
	 * @param form フォーム
	 * @return リダイレクト先
	 * @throws IOException
	 */
	@PostMapping("/register")
	public String post(PostForm form) throws IOException {
		postservice.post(form);
		return "redirect:/register";
	}
}
