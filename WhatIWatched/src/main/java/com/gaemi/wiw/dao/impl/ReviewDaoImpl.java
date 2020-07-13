package com.gaemi.wiw.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gaemi.wiw.dao.ReviewDao;
import com.gaemi.wiw.dto.ReviewDto;

@Repository
public class ReviewDaoImpl implements ReviewDao {
	
	@Autowired
	SqlSession sqlSession;
	
	private final String NAME_SPACE = "Reviews.";

	@Override
	public void writeReview(ReviewDto reviewDto) {
		sqlSession.insert(NAME_SPACE + "writeReview", reviewDto);
	}

	@Override
	public List<ReviewDto> getAllReviews() {
		List<ReviewDto> result = sqlSession.selectList(NAME_SPACE + "getAllReviews");
		return result;
	}

}
