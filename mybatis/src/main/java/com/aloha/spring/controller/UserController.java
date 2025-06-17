package com.aloha.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aloha.spring.dto.User;
import com.aloha.spring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	// 로거
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// 의존성 자동 주입
	@Autowired
	private UserService userService;
		
	@GetMapping("/signin")
	public String signin(Model model) {
		logger.info("회원가입 페이지 이동...");
		
		model.addAttribute("user", new User());
		return "user/signin";
	}
	
	@PostMapping("/signin")
	public String signinPost(@ModelAttribute @Validated User user, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) return "user/signin";
		
		int result = 0;
		try {
			 result = userService.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result > 0) {
			logger.info("회원가입 처리 완료...");
			return "user/success";
		} else {
			return "user/signin";
		}
	}
}
