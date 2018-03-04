package com.springboot.ordermgmt.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.ordermgmt.model.Order;
import com.springboot.ordermgmt.model.OrderItem;

@Component
public class OrderService {

	
	
	private static List<Order> orders = new ArrayList<>();

	static {
		//Initialize Data
		OrderItem item1 = new OrderItem("i11", "Pizza", "Thin Crust", Arrays
				.asList("mushroom", "onions", "bellpeppers",
						"cheese"));
		OrderItem item2 = new OrderItem("i12", "Sandwich", "Veggie",
				Arrays.asList("onions", "peppers", "lettuce"));
		OrderItem item3 = new OrderItem("i13", "Pizza", "Handmade Crust",
				Arrays.asList("onions", "pineapple"));
		OrderItem item4 = new OrderItem("i14", "Sandwich",
				"ChickenBurger", Arrays.asList(
						"chicken", "cheese", "onions"));

		Order order1 = new Order("101", "John",
				 new ArrayList<>(Arrays
						.asList(item1, item2)));

		Order order2 = new Order("102", "Martha",
				 new ArrayList<>(Arrays
						.asList(item3, item4)));
		
		Order order3 = new Order("103", "Jake",
				 new ArrayList<>(Arrays
						.asList(item3, item4)));

		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
	}
	
	public List<Order> retrieveAllOrders() {
		return orders;
	}
	
	public Order retrieveOrder(String orderId) {
		for (Order order : orders) {
			if (order.getOrderId().equals(orderId)) {
				return order;
			}
		}
		return null;
	}
	
	public void DeleteOrder(String orderId) {
Order order = retrieveOrder(orderId);
		
		if (order == null) {
			return;
		}
				orders.remove(order);
			
	}
	
	public Order UpdateOrder(String orderId,Order newOrder) {
		Order order = retrieveOrder(orderId);
		
		if (order == null) {
			return null;
		}
				orders.remove(order);
				newOrder.setOrderId(orderId);
				orders.add(newOrder);
				return newOrder;
			
			}
	
	public List<OrderItem> retrieveOrderItems(String orderId) {
		Order order = retrieveOrder(orderId);

		if (order == null) {
			return null;
		}

		return order.getOrderItemList();
	}
	
	public OrderItem retrieveOrderItem(String orderId, String orderItemId) {
		Order order = retrieveOrder(orderId);

		if (order == null) {
			return null;
		}

		for (OrderItem orderItem : order.getOrderItemList()) {
			if (orderItem.getItemId().equals(orderItemId)) {
				return orderItem;
			}
		}

		return null;
	}
	
	private SecureRandom randomNumber = new SecureRandom();

	public OrderItem addOrderItem(String orderId, OrderItem orderItem) {
		Order order = retrieveOrder(orderId);

		if (order == null) {
			return null;
		}

		String randomId = new BigInteger(130, randomNumber).toString(32);
		orderItem.setItemId(randomId);
		order.getOrderItemList().add(orderItem);

		return orderItem;
	}
	
	private SecureRandom randomNumberOrder = new SecureRandom();

	public Order addOrder(Order order) {
		if (order == null) {
			return null;
		}

		String randomId = new BigInteger(130, randomNumberOrder).toString(32);
		order.setOrderId(randomId);
		orders.add(order);
		return order;
	}
	
}
