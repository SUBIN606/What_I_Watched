package com.gaemi.wiw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gaemi.wiw.dao.UserDao;
import com.gaemi.wiw.dto.UserDto;
import com.gaemi.wiw.security.CustomUserDetails;
import com.gaemi.wiw.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public void RegisterUser(UserDto userInfo) {
		
		System.out.println("Resister User Info : " + userInfo);
		System.out.println("Befor Encoder : " + userInfo.getPassword());
		String endcodedPassword = bcryptPasswordEncoder.encode(userInfo.getPassword());
		System.out.println("After Encoder : " + endcodedPassword);
		
		userInfo.setPassword(endcodedPassword);
		
		userDao.RegisterUser(userInfo);
		
	}

}
