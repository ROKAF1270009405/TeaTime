package com.teatime.dto;

import java.util.Date;

public class shopDTO {

	private int shopno;           // 매장 번호
	private String name;          // 이름
	private String content;       // 소개
	private String addr;          // 주소
	private String workingtime;   // 영업시간
	private Date date;            // 등록일

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

	public shopDTO(int shopno, String name, String content, String addr, String workingtime, Date date) {
		super();
		this.shopno = shopno;
		this.name = name;
		this.content = content;
		this.addr = addr;
		this.workingtime = workingtime;
		this.date = date;
	}

	public shopDTO() {
		super();
	}

}
