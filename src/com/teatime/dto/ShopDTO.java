package com.teatime.dto;

import java.util.Date;

public class ShopDTO {

	private int shopno;           // 매장번호.
	private String name;          // 이름
	private String content;       // 내용
	private String addr;          // 주소
	private String workingtime;   // 영업시간
	private Date date;            // 등록일
	private float gpa;			  // 평점
	private int count;			  // 좋아요 갯수

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public ShopDTO(int shopno, String name, String content, String addr, String workingtime, Date date, float gpa, int count) {
		super();
		this.shopno = shopno;
		this.name = name;
		this.content = content;
		this.addr = addr;
		this.workingtime = workingtime;
		this.date = date;
		this.gpa = gpa;
		this.count = count;
	}

	public ShopDTO() {
		super();
	}

}
