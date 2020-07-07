package com.gaemi.wiw.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gaemi.wiw.dto.ReviewDto;
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
	
	@PostMapping("/write-processing")
	public String writePrecessing(ReviewDto reviewDto, @RequestParam("file") MultipartFile file) throws Exception{
		System.out.println(reviewDto);
		// 파일 태그 name
		String fileTag = "file";
		
	    // 업로드 파일이 저장될 경로
		
		// 파일 이름	
		//MultipartFile file = mtf.getFile(fileTag);
		if(file.isEmpty()) {
			System.out.println("파일이 없잖니;;");
		}else {
			String fileName = file.getOriginalFilename();
			// 파일 전송
			try {
			 //   file.transferTo(new File(filePath + fileName));
			  System.out.println(fileName);
			} catch(Exception e) {
			    System.out.println("업로드 오류");
			}
		}
		
		return "redirect:/";
	}
	

}
