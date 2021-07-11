package com.ecommerce;

/**
 * @author Barış Ayyıldız
 */

 /**
	* Order object, that is used in ECommerce app
  */
public class Order {

	/** product id */
	private String productId;
	/** customer id */
	private int customerId;
	/** trader id */
	private int traderId;
	/** state of the order, (WAITING, ACCEPTED, CANCELLED) */
	private OrderState state;

	/**
	 * Order constructor
	 * @param productId product id
	 * @param customerId customer id
	 * @param traderId trader id
	 */
	public Order(String productId, int customerId, int traderId){
		this.productId = productId;
		this.customerId = customerId;
		this.traderId = traderId;
		this.state = OrderState.WAITING;
	}

	/**
	 * Order constructor with the OrderState
	 * @param productId product id
	 * @param customerId customer id
	 * @param traderId trader id
	 * @param state state of the order
	 */
	public Order(String productId, int customerId, int traderId, OrderState state){
		this.productId = productId;
		this.customerId = customerId;
		this.traderId = traderId;
		this.state = state;
	}

	/**
	 * Returns the product id
	 * @return Product id
	 */
	public String getProductId(){
		return this.productId;
	}

	/**
	 * Returns the customer id
	 * @return Customer id
	 */
	public int getCustomerId(){
		return this.customerId;
	}

	/**
	 * Returns the trader id
	 * @return Trader id
	 */
	public int getTraderId(){
		return this.traderId;
	}

	/**
	 * Returns the status of order
	 * @return Status of order
	 */
	public OrderState getOrderStatus(){
		return this.state;
	}

	/**
	 * Sets product id with the product id
	 * @param productId product id
	 */
	public void setProductId(String productId){
		this.productId = productId;
	}

	/**
	 * Sets customer id with the customer id
	 * @param customerId customer id
	 */
	public void setCustomerId(int customerId){
		this.customerId = customerId;
	}
	
	/**
	 * Sets trader id with the trader id
	 * @param traderId
	 */
	public void setTraderId(int traderId){
		this.traderId = traderId;
	}

	/**
	 * Sets the status of order with the state
	 * @param state status of order
	 */
	public void setSOrderStatus(OrderState state){
		this.state = state;
	}

	/**
	 * Returns the string representation of the Order object
	 * @return String representation of the Order object
	 */
	@Override
	public String toString(){
		String str = "";
		str += "Product id :\t" + this.productId + "\n";
		str += "Customer id :\t" + this.customerId + "\n";
		str += "Trader id :\t" + this.traderId + "\n";
		str += "Order Status :\t" + this.state + "\n";
		return str;
	}

	
}
