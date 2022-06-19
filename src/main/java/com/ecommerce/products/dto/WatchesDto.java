package com.ecommerce.products.dto;

public class WatchesDto {
	
	private String brand;
	private String model;
	private String color;
	private String style;
	private String connectorType;
	private boolean waterRessistent;
	
	public WatchesDto() {
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
