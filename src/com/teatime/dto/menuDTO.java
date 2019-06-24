package com.teatime.dto;

public class menuDTO {

	private int menuno;
	private String name;
	private int price;
	private String foodkind;
	
	public int getMenuno() {
		return menuno;
	}
	public void setMenuno(int menuno) {
		this.menuno = menuno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFoodkind() {
		return foodkind;
	}
	public void setFoodkind(String foodkind) {
		this.foodkind = foodkind;
	}
	public menuDTO(int menuno, String name, int price, String foodkind) {
		super();
		this.menuno = menuno;
		this.name = name;
		this.price = price;
		this.foodkind = foodkind;
	}
	public menuDTO() {
		super();
	}
	
	
}
