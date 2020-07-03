package com.gaemi.wiw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaemi.wiw.util.MovieAPI;

@RequestMapping("/reviews")
@Controller
public class ReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@GetMapping("/write")
	public String WritePage() {
		logger.info("글쓰기 페이지로 이 동 한 다");
		return "/reviews/WriteReview";
	}
	
	@ResponseBody
	@GetMapping(value="/search", produces="application/String; charset=utf-8")
	public String search(String keyword, boolean viewMore, int nextStart) {
		
		System.out.println("viewMore ?????? : " + viewMore);
		
		System.out.println(nextStart);
		// json값으로 넘어옴
		String result = MovieAPI.searchMovie(keyword, nextStart);
		
		return result;
	}

}
