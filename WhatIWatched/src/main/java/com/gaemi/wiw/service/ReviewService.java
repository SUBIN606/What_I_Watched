package com.gaemi.wiw.service;

import java.util.List;

import com.gaemi.wiw.dto.ReviewDto;

public interface ReviewService {
	public void writeReview(ReviewDto reviewDto);
	
	public List<ReviewDto> getAllReviews();
}
