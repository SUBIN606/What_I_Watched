package com.gaemi.wiw.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ReviewDto implements Serializable{
	
	private int seq;
	private String title;
	private String subtitle;
	private String poster_img;
	private int rating;
	private String comment;
	private String content;
	
	public ReviewDto() {
	}

	public ReviewDto(int seq, String title, String subtitle, String poster_img, int rating, String comment,
			String content) {
		super();
		this.seq = seq;
		this.title = title;
		this.subtitle = subtitle;
		this.poster_img = poster_img;
		this.rating = rating;
		this.comment = comment;
		this.content = content;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getPoster_img() {
		return poster_img;
	}

	public void setPoster_img(String poster_img) {
		this.poster_img = poster_img;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ReviewDto [seq=" + seq + ", title=" + title + ", subtitle=" + subtitle + ", poster_img=" + poster_img
				+ ", rating=" + rating + ", comment=" + comment + ", content=" + content + "]";
	}

}
