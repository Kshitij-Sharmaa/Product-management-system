package com.cetpa.Model;

public class Product 
{
	private int pid;
	public int getPid() {
		return pid;
	}
	public Product() {}
	public Product(int pid, String name, String brand, int price) {
		
		this.pid = pid;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private String name;
	private String brand;
	private int price;
}
