package com.teatime.mypage.model;

public class MypageDTO {

	private String name;
	private float gap;
	private String photo;
	private int shopno;
	private String id;

	public MypageDTO(String name, float gap, String photo, int shopno, String id) {
		this.name = name;
		this.gap = gap;
		this.photo = photo;
		this.shopno = shopno;
		this.id = id;
	}

	public MypageDTO() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getGap() {
		return gap;
	}

	public void setGap(float gap) {
		this.gap = gap;
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

} // end MypageDTO class
