package com.teatime.menu.model;

public class MenuDTO {
	private int menuno;
	private int shopno;
	private String name;
	private String price;
	
	public MenuDTO(int menuno, int shopno, String name, String price) {
		this.menuno = menuno;
		this.shopno = shopno;
		this.name = name;
		this.price = price;
	}
	public MenuDTO() {}
	public int getMenuno() {
		return menuno;
	}
	public void setMenuno(int menuno) {
		this.menuno = menuno;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
