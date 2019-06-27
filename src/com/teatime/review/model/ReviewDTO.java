package com.teatime.review.model;

import java.util.Date;

public class ReviewDTO {
	private int reviewno;
	private String title;
	private String content;
	private String date;
	private String photo;
	private float gpa;
	private int shopno;
	private String id;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReviewno() {
		return reviewno;
	}
	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public int getShopno() {
		return shopno;
	}
	public void setShopno(int shopno) {
		this.shopno = shopno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ReviewDTO(int reviewno, String title, String content, String date, String photo, float gpa, int shopno,
			String id) {
		super();
		this.reviewno = reviewno;
		this.title = title;
		this.content = content;
		this.date = date;
		this.photo = photo;
		this.gpa = gpa;
		this.shopno = shopno;
		this.id = id;
	}
	public ReviewDTO() {
		super();
	}
	

}
