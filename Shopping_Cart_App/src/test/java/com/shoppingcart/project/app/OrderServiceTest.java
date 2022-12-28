package com.shoppingcart.project.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shoppingcart.project.app.Repository.OrderRepository;
import com.shoppingcart.project.app.model.Order;
import com.shoppingcart.project.app.service.OrderService;

@SpringBootTest
public class OrderServiceTest {

	@Autowired
	private OrderService orderService;
	
	@MockBean
	private OrderRepository orderRepository;
	
	@Test
	public void getAllOrdersTest() {
		Order order = new Order();
		
		order.setOrderNumber(1L);
		order.setStatus(true);
		order.setComments("Delivered");
		order.setOrderDate(new Date(2022, 12, 4));
		order.setRequiredDate(new Date(2022, 12, 14));
		
		Mockito.when(orderRepository.save(order)).
		thenReturn(order);
		assertThat(orderService.getAllOrders()).
		isNotNull();
	}
	
	@Test
	public void getOrderByIdTest() {
		Order order = new Order();
		
		order.setOrderNumber(1L);
		order.setStatus(true);
		order.setComments("Delivered");
		order.setOrderDate(new Date(2022, 12, 4));
		order.setRequiredDate(new Date(2022, 12, 14));
		
		Mockito.when(orderRepository.save(order)).
		thenReturn(order);
		assertThat(orderService.getOrderById(1L)).
		isNotNull();
	}
	
	@Test
	public void addOrderTest() {
		Order order = new Order();
		
		order.setOrderNumber(1L);
		order.setStatus(true);
		order.setComments("Delivered");
		order.setOrderDate(new Date(2022, 12, 4));
		order.setRequiredDate(new Date(2022, 12, 14));
		
		Mockito.when(orderRepository.save(order)).
		thenReturn(order);
		assertThat(orderService.createOrder(order)).
		isEqualTo(order);
	}

	@Test
	public void deleteOrderTest() {
		Order order = new Order();
		
		order.setOrderNumber(1L);
		order.setStatus(true);
		order.setComments("Delivered");
		order.setOrderDate(new Date(2022, 12, 4));
		order.setRequiredDate(new Date(2022, 12, 14));
		
		Mockito.when(orderRepository.save(order)).
		thenReturn(order);
		orderService.deleteOrder(1L);
		assertThat(orderService.getOrderById(1L)).
		isEmpty();
	}
	
	@Test
	public void updateOrderTest() {
		Order order = new Order();
		
		order.setOrderNumber(1L);
		order.setStatus(true);
		order.setComments("Delivered");
		order.setOrderDate(new Date(2022, 12, 4));
		order.setRequiredDate(new Date(2022, 12, 14));
		
		Mockito.when(orderRepository.save(order)).
		thenReturn(order);
		orderService.updateOrder(order, 2L);
		assertThat(orderService.getOrderById(1L)).
		isEmpty();
	}
	

}