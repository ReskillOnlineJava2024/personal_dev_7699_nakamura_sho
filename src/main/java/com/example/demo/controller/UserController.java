package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	Account account;
	
	@Autowired
	UserRepository userRepository;
	
	
	//ログイン画面表示
	@GetMapping({"/login", "/logout"})
	public String index() {
		session.invalidate();
		return "login";
	}
	
	//ログイン処理
	@PostMapping("/login")
	public String login(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {
		
		if(email.length() == 0 || password.length() == 0 || password  == null || password == null) {
			model.addAttribute("errorMessage","メールアドレスまたはパスワードが未入力です");
			return "login";
		}

		List<User> userList = userRepository.findByEmailAndPassword(email, password);
		if (userList == null || userList.size() == 0) {
			model.addAttribute("errorMessage", "メールアドレスとパスワードが一致しませんでした");
			return "login";
		}
		User user = userList.get(0);

		// セッション管理されたアカウント情報にIDと名前をセット
		account.setId(user.getId());
		account.setName(user.getName());

		return "redirect:/sns";
	}
	
	//ユーザー新規登録画面表示
	@GetMapping("/user/new")
	public String newUser() {
		return "newUser";
	}
	
	//新規登録処理
	@PostMapping("/users/add")
	public String store(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam("password") String password,
			@RequestParam("password_confirm") String passwordConfilm, 
			Model model) {
		
		if (!(password.equals(passwordConfilm))) {
			model.addAttribute("errorMessage","パスワードと確認用パスワードが一致しませんでした");
			model.addAttribute("name", name);
			model.addAttribute("email", email);
			return "newUser";
		}
		
		User user = new User(name, email, password);
		
		userRepository.save(user);
		
		return "redirect:/login";
	}
}
