package com.gaemi.wiw.dto;

import java.io.Serializable;
import java.util.Date;
/*
 CREATE TABLE REVIEWS
(
    SEQ NUMBER PRIMARY KEY,
    AUTHOR VARCHAR2(50) NOT NULL,
    TITLE VARCHAR2(300) NOT NULL,
    SUBTITLE VARCHAR2(500),
    POSTER_IMG VARCHAR2(300),
    RATING NUMBER(10) NOT NULL,
    SHORT_COMMENT VARCHAR2(500),
    CONTENT VARCHAR2(2000),
    REGDATE DATE DEFAULT SYSDATE
);
*/
@SuppressWarnings("serial")
public class ReviewDto implements Serializable{
	
	private int seq;
	private String author;
	private String title;
	private String subtitle;
	private String poster_img;
	private int rating;
	private String short_comment;
	private String content;
	private Date regdate;
	
	public ReviewDto() {
	}

	public ReviewDto(int seq, String author, String title, String subtitle, String poster_img, int rating,
			String short_comment, String content, Date regdate) {
		super();
		this.seq = seq;
		this.author = author;
		this.title = title;
		this.subtitle = subtitle;
		this.poster_img = poster_img;
		this.rating = rating;
		this.short_comment = short_comment;
		this.content = content;
		this.regdate = regdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public String getShort_comment() {
		return short_comment;
	}

	public void setShort_comment(String short_comment) {
		this.short_comment = short_comment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "ReviewDto [seq=" + seq + ", author=" + author + ", title=" + title + ", subtitle=" + subtitle
				+ ", poster_img=" + poster_img + ", rating=" + rating + ", short_comment=" + short_comment
				+ ", content=" + content + ", regdate=" + regdate + "]";
	}
	
}
