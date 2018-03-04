package com.springboot.ordermgmt.model;

import java.util.List;

public class Order {
	
	private String orderId;
	private String customerName;
	private List<OrderItem> orderItemList;
	
	public Order(){
		
	}
	
	public Order(String orderId, String customerName, List<OrderItem> orderItemList) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.orderItemList = orderItemList;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	@Override
	public String toString() {
		return String.format(
				"Order [orderId=%s, customerName=%s, orderItemList=%s]", orderId,
				customerName, orderItemList);
	}


	
}
