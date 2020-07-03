package com.gaemi.wiw.dao;

import com.gaemi.wiw.dto.UserDto;
import com.gaemi.wiw.security.CustomUserDetails;

public interface UserDao {
	
	public void RegisterUser(UserDto userInfo);
	
	public CustomUserDetails getUserById(String id);
	
}
