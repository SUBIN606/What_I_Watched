package com.gaemi.wiw.dao.impl;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gaemi.wiw.dao.UserDao;
import com.gaemi.wiw.dto.UserDto;
import com.gaemi.wiw.security.CustomUserDetails;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SqlSession sqlSession;
	
	private final String NAME_SPACE = "Users.";

	@Override
	public void RegisterUser(UserDto userInfo) {		
		sqlSession.insert(NAME_SPACE + "register" , userInfo);
	}

	@Override
	public CustomUserDetails getUserById(String id) {
		CustomUserDetails users = sqlSession.selectOne(NAME_SPACE + "getUserById", id);
		return users;
	}

}
