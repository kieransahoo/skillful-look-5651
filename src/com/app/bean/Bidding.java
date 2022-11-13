package com.app.bean;

public class Bidding {
	private int productId;
	private int buyerId;
	private int bidPrice;
	
	public Bidding() {
		
	}

	public Bidding(int productId, int buyerId, int bidPrice) {
		super();
		this.productId = productId;
		this.buyerId = buyerId;
		this.bidPrice = bidPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}

	@Override
	public String toString() {
		return "Bidding [productId=" + productId + ", buyerId=" + buyerId + ", bidPrice=" + bidPrice + "]";
	}
	
	
}
