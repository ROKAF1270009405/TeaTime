package com.teatime.best.model;

public class BestDTO {
	private int shopno;           // 매장번호.
	private String name;          // 이름
	private String content;       // 내용
	private String addr;          // 주소
	private String workingtime;   // 영업시간
	private String date;          // 등록일
	private String photo;		  // 사진
	private float gpa;			  // 평점
	private int count;			  // 좋아요 갯수
	public BestDTO(int shopno, String name, String content, String addr, String workingtime, String date, String photo,
			float gpa, int count) {
		this.shopno = shopno;
		this.name = name;
		this.content = content;
		this.addr = addr;
		this.workingtime = workingtime;
		this.date = date;
		this.photo = photo;
		this.gpa = gpa;
		this.count = count;
	}
	public BestDTO() {}
	
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
