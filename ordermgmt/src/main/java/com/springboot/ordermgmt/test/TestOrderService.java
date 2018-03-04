package com.springboot.ordermgmt.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.springboot.ordermgmt.model.Order;
import com.springboot.ordermgmt.model.OrderItem;
import com.springboot.ordermgmt.service.OrderService;

public class TestOrderService {

	OrderService orderService = new OrderService();
	

	@Test
	public void testRetrieveOrder() {
		orderService.retrieveOrder("101");
		orderService.retrieveOrder("110");
		orderService.retrieveOrder(null);
	}

	@Test
	public void testDeleteOrder() {
		orderService.DeleteOrder("101");
		orderService.DeleteOrder("110");
		orderService.DeleteOrder(null);
	}

	@Test
	public void testUpdateOrder() {
		OrderItem item1 = new OrderItem("i11", "Pizza", "Thin Crust", Arrays
				.asList("mushroom", "onions", "bellpeppers",
						"cheese"));
		OrderItem item2 = new OrderItem("i12", "Sandwich", "Veggie",
				Arrays.asList("onions", "peppers", "lettuce"));
		
		Order order1 = new Order(null, "John",
				 new ArrayList<>(Arrays
						.asList(item1, item2)));
		orderService.UpdateOrder("101", order1);
		orderService.UpdateOrder("110", order1);
		orderService.UpdateOrder(null, order1);
	}

	@Test
	public void testRetrieveOrderItems() {
		orderService.retrieveOrderItems("101");
		orderService.retrieveOrderItems("110");
		orderService.retrieveOrderItems(null);
	}

	@Test
	public void testRetrieveOrderItem() {
		orderService.retrieveOrderItem("101","i11");
		orderService.retrieveOrderItem("101","i1122");
		orderService.retrieveOrderItem(null,"i11");
	}

	@Test
	public void testAddOrderItem() {
		OrderItem item1 = new OrderItem("i11", "Pizza", "Thin Crust", Arrays
				.asList("mushroom", "onions", "bellpeppers",
						"cheese"));
		orderService.addOrderItem("101", item1);
		orderService.addOrderItem("110", item1);
		orderService.addOrderItem(null, item1);
	}

	@Test
	public void testAddOrder() {
		OrderItem item1 = new OrderItem("i11", "Pizza", "Thin Crust", Arrays
				.asList("mushroom", "onions", "bellpeppers",
						"cheese"));
		OrderItem item2 = new OrderItem("i12", "Sandwich", "Veggie",
				Arrays.asList("onions", "peppers", "lettuce"));
		
		Order order1 = new Order(null, "John",
				 new ArrayList<>(Arrays
						.asList(item1, item2)));
		orderService.addOrder(order1);
		orderService.addOrder(null);
	}

}
