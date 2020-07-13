package com.gaemi.wiw.util;

public class UseBeanUtils {
	
	private String poster_img;
	
	public String getPoster_img() {
		if(poster_img.indexOf("https") == -1) {
			return "../resources/upload/" + poster_img;
		}
		return poster_img;
	}

	public void setPoster_img(String poster_img) {
		this.poster_img = poster_img;
	}

}
