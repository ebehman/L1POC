package com.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="watches")
public class Watches {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;
	private String brand;
	private String model;
	private String color;
	private String style;
	private String connectorType;
	private boolean waterRessistent;
	
	
	public Watches() {
	
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


	public String getStyle() {
		return style;
	}


	public void setStyle(String style) {
		this.style = style;
	}


	public String getConnectorType() {
		return connectorType;
	}


	public void setConnectorType(String connectorType) {
		this.connectorType = connectorType;
	}


	public boolean isWaterRessistent() {
		return waterRessistent;
	}


	public void setWaterRessistent(boolean waterRessistent) {
		this.waterRessistent = waterRessistent;
	}
	
	
	
}
