package com.gaemi.wiw;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gaemi.wiw.security.CustomUserDetails;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, Principal principal) {
		logger.info("Home Controller ");
				
		if(principal == null) {
			logger.info("***********************************유저정보 없음******************************************");
		}else {
		
			CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			logger.info("//////////////// 유저 name :" + user.getName());
			logger.info("//////////////// 유저 프로필 이미지 :" + user.getProfile_img());
			logger.info("//////////////// 유저 auth : " + user.getAuthorities() + principal.toString());
		}
		
		return "home";
	}
	
}
