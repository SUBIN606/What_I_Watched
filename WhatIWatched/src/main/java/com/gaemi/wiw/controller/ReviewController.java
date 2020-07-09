package com.gaemi.wiw.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gaemi.wiw.dto.ReviewDto;
import com.gaemi.wiw.security.CustomUserDetails;
import com.gaemi.wiw.service.ReviewService;
import com.gaemi.wiw.util.FileUtility;
import com.gaemi.wiw.util.MovieAPI;

@RequestMapping("/reviews")
@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
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
	
	@PostMapping("/write-processing")
	public String writePrecessing(ReviewDto reviewDto, Principal principal,
									@RequestParam("file") MultipartFile file) throws Exception{
		CustomUserDetails user = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		reviewDto.setAuthor(user.getUsername());
		
		// poster를 직접 올렸을 경우
		if(!file.isEmpty()) {
			String uploadResult = FileUtility.saveFile(file);
			logger.info("파일 업로드 결과 : "+uploadResult);
			if(uploadResult != null) {
				reviewDto.setPoster_img(uploadResult);
			}
		}
		
		logger.info("저장 할 reviewDto : " + reviewDto);
		reviewService.writeReview(reviewDto);
		
		return "redirect:/";
	}
	

}
