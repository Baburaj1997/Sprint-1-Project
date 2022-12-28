package com.shoppingcart.project.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.project.app.Repository.OrderRepository;
import com.shoppingcart.project.app.model.Order;
import com.shoppingcart.project.app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	//get all Orders
	public List<Order> getAllOrders(){
		List<Order> list = orderRepository.findAll();
		return list;
	}
	
	//get single Order by id
	public Optional<Order> getOrderById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		return order;
	}
	
	//adding the Order
	public Order createOrder(Order order) {
		Order result = orderRepository.save(order);
		return result;
	}
	
	//delete Order by id
	public void deleteOrder(Long oid) {
		orderRepository.deleteById(oid);
	}
	
	//update Order
	public void updateOrder(Order order, Long orderId) {
		order.setOrderNumber(orderId);
		orderRepository.save(order);
	}
}
