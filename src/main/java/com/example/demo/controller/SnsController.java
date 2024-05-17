package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Post;
import com.example.demo.repository.SnsRepository;

@Controller
public class SnsController {
	
	@Autowired
	SnsRepository snsRepository;
	
	//メッセージ一覧（ホーム）画面表示
	@GetMapping("/sns")
	public String index(
			@RequestParam(name = "keyword", defaultValue = "")String  keyword,
			Model model) {
		
		List<Post> postList = null;
		
		if (keyword.length() > 0) {
			postList = snsRepository.findByMessageContaining(keyword);
		} else {
			postList = snsRepository.findAll();
		}
		
		model.addAttribute("postList", postList);
		return "sns";
	}
	
	//新規作成画面表示
	@GetMapping("/sns/post")
	public String newPost() {
		return "newPost";
	}
	
	//新規登録処理
//	@PostMapping("/sns/post")
//	public String addPost() {
//		
//	}
}
