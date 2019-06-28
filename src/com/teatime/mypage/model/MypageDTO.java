package com.teatime.mypage.model;

public class MypageDTO {

	private String name;
	private float gpa;
	private String photo;
	private int shopno;
	private String id;
	private String content;
	private int reviewno;

	public MypageDTO(String name, float gpa, String photo, int shopno, String id, String content, int reviewno) {
		this.name = name;
		this.gpa = gpa;
		this.photo = photo;
		this.shopno = shopno;
		this.id = id;
		this.content = content;
		this.reviewno = reviewno;
	}

	public MypageDTO() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public int getReviewno() {
		return reviewno;
	}
	
	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}

} // end MypageDTO class
