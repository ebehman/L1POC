package com.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String brand;
	private String model;
	private String color;
	private String lssdCapacity;
	private String los;
	private String lweight;

	public Laptop() {
	}



	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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
		return lssdCapacity;
	}

	public void setSsdCapacity(String ssdCapacity) {
		this.lssdCapacity = ssdCapacity;
	}

	public String getOs() {
		return los;
	}

	public void setOs(String os) {
		this.los = os;
	}

	public String getWeight() {
		return lweight;
	}

	public void setWeight(String weight) {
		this.lweight = weight;
	}

}
