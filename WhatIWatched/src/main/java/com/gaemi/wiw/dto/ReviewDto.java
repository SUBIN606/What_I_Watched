package com.gaemi.wiw.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ReviewDto implements Serializable{
	
	private int seq;
	private String title;
	private String subtitle;
	private int rating;
	private String comment;
	private String review;
	
	public ReviewDto() {
	}

	public ReviewDto(int seq, String title, String subtitle, int rating, String comment, String review) {
		super();
		this.seq = seq;
		this.title = title;
		this.subtitle = subtitle;
		this.rating = rating;
		this.comment = comment;
		this.review = review;
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "ReviewDto [seq=" + seq + ", title=" + title + ", subtitle=" + subtitle + ", rating=" + rating
				+ ", comment=" + comment + ", review=" + review + "]";
	}
	
}
