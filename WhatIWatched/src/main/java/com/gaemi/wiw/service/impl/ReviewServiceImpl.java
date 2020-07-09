package com.gaemi.wiw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaemi.wiw.dao.ReviewDao;
import com.gaemi.wiw.dto.ReviewDto;
import com.gaemi.wiw.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;
	
	@Override
	public void writeReview(ReviewDto reviewDto) {
		reviewDao.writeReview(reviewDto);
	}

}
