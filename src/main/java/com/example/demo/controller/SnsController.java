package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Post;
import com.example.demo.model.Account;
import com.example.demo.repository.SnsRepository;

@Controller
public class SnsController {
	
	@Autowired
	Account account;;
	
	@Autowired
	SnsRepository snsRepository;
	
	//メッセージ一覧（ホーム）画面表示
	@GetMapping("/sns")
	public String index(
			@RequestParam(name = "keyword", defaultValue = "")String  keyword,
			Pageable pageable,
			Model model) {
		
		Page<Post> pageList = null;
		
		if (keyword.length() > 0) {
			pageList = snsRepository.findByMessageContainingOrderByIdDesc(keyword, pageable);
		} else {
			pageList = snsRepository. findAllByOrderByIdDesc(pageable);
		}
		
		List<Post> postList = pageList.getContent();
		
		model.addAttribute("keyword",keyword);
		model.addAttribute("pages", pageList);
		model.addAttribute("postList", postList);
		return "sns";
	}
	
	//新規作成画面表示
	@GetMapping("/sns/post")
	public String newPost() {
		return "newPost";
	}
	
	//新規登録処理
	@PostMapping("/sns/post")
	public String addPost(
			@RequestParam("userId") Integer userId,
			@RequestParam("message") String message,
			Model model) {
		
		if(message.length() >140) {
			model.addAttribute("errorMessage", "140字以内で入力してください");
			model.addAttribute("message", message);
			return "newPost";
		}
		
		Post post = new Post(userId, message);
		
		snsRepository.save(post);
		
		return "redirect:/sns";
	}
	
	// 削除処理
	@PostMapping("/sns/{id}/delete")
	public String delete(@PathVariable("id") Integer id, 
			Model model) {

		snsRepository.deleteById(id);
		return "redirect:/sns";
	}
	
	//自身が投降したものの一覧画面表示
	@GetMapping("/sns/{id}/myPostList")
	public String myIndex(
			@PathVariable("id") Integer id, 
			@RequestParam(name = "keyword", defaultValue = "")String  keyword,
			Pageable pageable,
			Model model) {
		
		Page<Post> pageList = null;
		
		if (keyword.length() > 0) {
			 pageList = snsRepository.findByUserIdAndMessageContainingOrderByIdDesc(id, keyword, pageable);
		} else {
			pageList = snsRepository. findByUserIdOrderByIdDesc(id, pageable);
		}
		
		List<Post> postList = pageList.getContent();
		
		model.addAttribute("keyword",keyword);
		model.addAttribute("pages", pageList);
		model.addAttribute("postList", postList);
		return "myPostList";
	}
}
