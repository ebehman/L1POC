package com.ecommerce.products.dto;

public class LaptopDto {

	private String brand;
	private String model;
	private String color;
	private String ssdCapacity;
	private String os;
	private String weight;



	

	public LaptopDto() {
		super();
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSsdCapacity() {
		return ssdCapacity;
	}

	public void setSsdCapacity(String ssdCapacity) {
		this.ssdCapacity = ssdCapacity;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}
