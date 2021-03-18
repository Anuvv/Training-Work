
//	MODEL CLASS FOR PRODUCT

package com.pkart.model;

import java.util.Date;

public class Product {

	private long id;
	private String name;
	private double price;
	private long quantity;
	private Date manufacturedDate;
	private Date expiryDate;
	
	public Product() {}
	
	public Product(long id,String name,double price,long quantity,Date manufacturedDate,Date expiryDate)
	{
		this.id=id;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		this.manufacturedDate=manufacturedDate;
		this.expiryDate=expiryDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Date getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", manufacturedDate=" + manufacturedDate + ", expiryDate=" + expiryDate + "]"+"\n";
	}
	
	
}
