package com.gaemi.wiw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gaemi.wiw.dto.UserDto;
import com.gaemi.wiw.service.UserService;

@RequestMapping("/users")
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/login")
	public void loginPage() {
		logger.info("로그인 페이지로 이동~");
	}
	
	
	@GetMapping("/register")
	public String registerPage() {
		return "/users/register";
	}
	
	@PostMapping("/registerAf")
	public String registerProcessing(UserDto userInfo) {
		logger.info("회원가입 정보 도착 : " + userInfo.toString());
		userService.RegisterUser(userInfo);
		return "redirect:/";
	}
	
	@GetMapping("/member") 
	public void doMember() { 
		logger.info("logined member"); 
	} 
	
	@GetMapping("/admin") 
	public void doAdmin() { 
		logger.info("admin only"); 
	}


}
