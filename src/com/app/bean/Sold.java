package com.app.bean;

import java.sql.Date;

public class Sold {
	private int productID;
	private String productName;
	private int Price;
	private int buyerId;
	private Date soldDate;
	
	
	public Sold() {
		
	}


	public Sold(int productID, String productName, int price, int buyerId, Date soldDate) {
		super();
		this.productID = productID;
		this.productName = productName;
		Price = price;
		this.buyerId = buyerId;
		this.soldDate = soldDate;
	}


	public int getProductID() {
		return productID;
	}


	public void setProductID(int productID) {
		this.productID = productID;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getPrice() {
		return Price;
	}


	public void setPrice(int price) {
		Price = price;
	}


	public int getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}


	public Date getSoldDate() {
		return soldDate;
	}


	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}


	@Override
	public String toString() {
		return "Sold [productID=" + productID + ", productName=" + productName + ", Price=" + Price + ", buyerId="
				+ buyerId + ", soldDate=" + soldDate + "]";
	}
	
	
	
	
	
	
	
}
