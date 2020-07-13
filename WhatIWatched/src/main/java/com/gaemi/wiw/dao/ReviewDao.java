package com.gaemi.wiw.dao;

import java.util.List;

import com.gaemi.wiw.dto.ReviewDto;

public interface ReviewDao {
	public void writeReview(ReviewDto reviewDto);
	
	public List<ReviewDto> getAllReviews();
}
