package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String index(
			@RequestParam(name = "error", defaultValue = "") String error,
			Model model) {
		session.invalidate();
		// エラーパラメータのチェック
		if (error.equals("notLoggedIn")) {
			model.addAttribute("errorMessage", "セッションが切れました。再度ログインしてください。");
		}
		return "login";
	}
	
	//ログイン処理
	@PostMapping("/login")
	public String login(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {

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
			Model model) {
		
		User user = new User(name, email, password);
		
		userRepository.save(user);
		
		return "redirect:/login";
	}
	
	//アカウント情報画面表示
	@GetMapping("user/{id}/userInfo")
	public String userIndex(
			@PathVariable("id") Integer id, Model model) {
		
		User user = userRepository.findById(id).get();
		model.addAttribute("user", user);
		
		return "userInfo";
	}
	
	//アカウント情報編集画面表示
	@GetMapping("/user/{id}/edit")
	public String userEdit(
			@PathVariable("id") Integer id, Model model) {
		
		User user = userRepository.findById(id).get();
		model.addAttribute("user", user);
		
		return "editUser";
	}
	
	// 更新処理
	@PostMapping("/user/{id}/edit")
	public String userUpdate(
			@PathVariable("id") Integer id,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam("password") String password,
			Model model) {
		
		User user = new User(id, name, email, password);
		userRepository.save(user);
		return "redirect:/logout";
	}
}
