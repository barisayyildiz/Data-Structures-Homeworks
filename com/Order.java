package com;

public class Order {

	private String productId;
	private int customerId;
	private int traderId;
	private OrderState state;

	public Order(String productId, int customerId, int traderId){
		this.productId = productId;
		this.customerId = customerId;
		this.traderId = traderId;
		this.state = OrderState.WAITING;
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
	public OrderState getOrderStatus(){
		return this.state;
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
	public void setSOrderStatus(OrderState state){
		this.state = state;
	}

	@Override
	public String toString(){
		return this.productId + ";" + this.customerId + ";" + this.traderId;
	}

	
}
