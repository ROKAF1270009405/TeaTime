package com.teatime.detail.model;

public class DetailDTO {
	
	// 매장 정보
	private int shopno;
	private String name;
	private String content;
	private String photo;
	private String addr;
	private String workingtime;
	private String date;
	
	// 좋아요횟수
	private int good;
	
	//평점
	private float gpa;
	
	public DetailDTO() {
	}

	public DetailDTO(int shopno, String name, String content, String photo, String addr, String workingtime,
			String date, int good, float gpa) {
		this.shopno = shopno;
		this.name = name;
		this.content = content;
		this.photo = photo;
		this.addr = addr;
		this.workingtime = workingtime;
		this.date = date;
		this.good = good;
		this.gpa = gpa;
	}

	public int getShopno() {
		return shopno;
	}

	public void setShopno(int shopno) {
		this.shopno = shopno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getWorkingtime() {
		return workingtime;
	}

	public void setWorkingtime(String workingtime) {
		this.workingtime = workingtime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	
}
