package com.shoppingcart.project.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shoppingcart.project.app.model.Order;

@Component
public interface OrderService {
	
	public List<Order> getAllOrders();
	
	public Optional<Order> getOrderById(Long id);
	
	public Order createOrder(Order order);
	
	public void deleteOrder(Long oid);
	
	public void updateOrder(Order order, Long orderId);
	

}
