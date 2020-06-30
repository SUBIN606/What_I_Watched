package com.gaemi.wiw.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserDto implements Serializable{
	
	private String id;
	private String password;
	private String name;
	private String auth;
	private int enabled;
	
	public UserDto() {
		
	}
	
	public UserDto(String id, String password, String name, String auth, int enabled) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.auth = auth;
		this.enabled = enabled;
	}
	
	public UserDto(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", password=" + password + ", name=" + name + ", auth=" + auth + ", enabled="
				+ enabled + "]";
	}
	
	
}
