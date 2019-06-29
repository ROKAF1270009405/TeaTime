package com.teatime.review.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewDTO {
	private int reviewno;
	private String title;
	private String content;
	private String date;
	private List<String> photo;
	private float gpa;
	private int shopno;
	private String id;
	private String name;
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "ReviewDTO [reviewno=" + reviewno + ", title=" + title + ", content=" + content + ", date=" + date
				+ ", photo=" + photo + ", gpa=" + gpa + ", shopno=" + shopno + ", id=" + id + ", name=" + name + "]";
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
	public List<String> getPhoto() {
		return photo;
	}
	public void setPhoto(List<String> photo) {
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
	public ReviewDTO(int reviewno, String title, String content, String date, ArrayList<String> photo, float gpa, int shopno,
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
