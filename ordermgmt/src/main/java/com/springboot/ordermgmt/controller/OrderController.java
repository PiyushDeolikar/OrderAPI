package com.springboot.ordermgmt.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.ordermgmt.model.Order;
import com.springboot.ordermgmt.model.OrderItem;
import com.springboot.ordermgmt.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders/orders")
	public List<Order> retrieveAllOrder() {
		return orderService.retrieveAllOrders();
	}
	
	@DeleteMapping("/orders/{orderId}/order")
	public void deleteOrder(@PathVariable String orderId) {
		orderService.DeleteOrder(orderId);
	}
	
	@GetMapping("/orders/{orderId}/order")
	public Order retrieveOrder(@PathVariable String orderId) {
		return orderService.retrieveOrder(orderId);
	}
	
	@PutMapping("/orders/{orderId}/order")
	public Order UpdateOrder(@RequestBody Order order, @PathVariable String orderId) {
		return orderService.UpdateOrder(orderId, order);
	}
	
	@GetMapping("/orders/{orderId}/orderItems")
	public List<OrderItem> retrieveOrderItemsForOrder(@PathVariable String orderId) {
		return orderService.retrieveOrderItems(orderId);
	}
	
	@GetMapping("/orders/{orderId}/orderItems/{orderItemId}")
	public OrderItem retrieveDetailsForOrderItem(@PathVariable String orderId,
			@PathVariable String orderItemId) {
		return orderService.retrieveOrderItem(orderId, orderItemId);
	}
	
	
	
	@PostMapping("/orders/{orderId}/orderItems")
	public ResponseEntity<Void> addOrderItemtoOrder(
			@PathVariable String orderId, @RequestBody OrderItem newOrderItem) {

		OrderItem orderItem = orderService.addOrderItem(orderId, newOrderItem);

		if (orderItem == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{orderItemId}").buildAndExpand(orderItem.getItemId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Void> addOrder(@RequestBody Order order) {

	Order newOrder =orderService.addOrder(order);
		if (order == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{orderId}").buildAndExpand(newOrder.getOrderId()).toUri();

		return ResponseEntity.created(location).build();
	}

}
