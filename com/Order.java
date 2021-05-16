package com;

public class Order {

	private String productId;
	private int customerId;
	private int traderId;

	public Order(String productId, int customerId, int traderId){
		this.productId = productId;
		this.customerId = customerId;
		this.traderId = traderId;
	}

	public String getProductId(){
		return this.productId;
	}
	public int getCustomerId(){
		return this.customerId;
	}
	public int getTraderId(){
		return this.traderId;
	}
	public void setProductId(String productId){
		this.productId = productId;
	}
	public void setCustomerId(int customerId){
		this.customerId = customerId;
	}
	public void setTraderId(int traderId){
		this.traderId = traderId;
	}

	@Override
	public String toString(){
		return this.productId + ";" + this.customerId + ";" + this.traderId;
	}

	
}
