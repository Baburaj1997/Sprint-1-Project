package com.shoppingcart.project.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shoppingcart.project.app.Repository.OrderDetailRepository;
import com.shoppingcart.project.app.model.OrderDetail;
import com.shoppingcart.project.app.service.OrderDetailService;

@SpringBootTest
public class OrderDetailServiceTest {

	@Autowired
	private OrderDetailService orderDetailService;
	
	@MockBean
	private OrderDetailRepository orderDetailRepository;
	
	@Test
	public void getAllOrderDetailsTest() {
		OrderDetail orderDetail = new OrderDetail();
		
		orderDetail.setOrderNumber(1L);
		orderDetail.setOrderLineNumber(2);
		orderDetail.setPriceEach(50.98);
		orderDetail.setQuantityOrdered(10);
		
		Mockito.when(orderDetailRepository.save(orderDetail)).
		thenReturn(orderDetail);
		assertThat(orderDetailService.getAllOrderDetails()).
		isNotNull();
	}
	
	@Test
	public void getOrderDetailByIdTest() {
		OrderDetail orderDetail = new OrderDetail();
		
		orderDetail.setOrderNumber(1L);
		orderDetail.setOrderLineNumber(2);
		orderDetail.setPriceEach(50.98);
		orderDetail.setQuantityOrdered(10);
		
		Mockito.when(orderDetailRepository.save(orderDetail)).
		thenReturn(orderDetail);
		assertThat(orderDetailService.getOrderDetailById(1L)).
		isNotNull();
	}
	
	@Test
	public void addOrderDetailIdTest() {
		OrderDetail orderDetail = new OrderDetail();
		
		orderDetail.setOrderNumber(1L);
		orderDetail.setOrderLineNumber(2);
		orderDetail.setPriceEach(50.98);
		orderDetail.setQuantityOrdered(10);
		
		Mockito.when(orderDetailRepository.save(orderDetail)).
		thenReturn(orderDetail);
		assertThat(orderDetailService.createOrderDetail(orderDetail)).
		isEqualTo(orderDetail);
		
	}

	@Test
	public void deleteOrderDetailTest() {
		OrderDetail orderDetail = new OrderDetail();
		
		orderDetail.setOrderNumber(1L);
		orderDetail.setOrderLineNumber(2);
		orderDetail.setPriceEach(50.98);
		orderDetail.setQuantityOrdered(10);
		
		Mockito.when(orderDetailRepository.save(orderDetail)).
		thenReturn(orderDetail);
		orderDetailService.deleteOrderDetail(1L);
		assertThat(orderDetailService.getOrderDetailById(1L)).
		isEmpty();
		
	}
	
	@Test
	public void updateOrderDetailTest() {
		OrderDetail orderDetail = new OrderDetail();
		
		orderDetail.setOrderNumber(1L);
		orderDetail.setOrderLineNumber(2);
		orderDetail.setPriceEach(50.98);
		orderDetail.setQuantityOrdered(10);
		
		Mockito.when(orderDetailRepository.save(orderDetail)).
		thenReturn(orderDetail);
		orderDetailService.updateOrderDetail(orderDetail, 2L);
		assertThat(orderDetailService.getOrderDetailById(1L)).
		isEmpty();
		
	}
	
	@Test
	public void getOrderDetailsUsingPagingTest() {
		OrderDetail orderDetail = new OrderDetail();
		
		orderDetail.setOrderNumber(1L);
		orderDetail.setOrderLineNumber(2);
		orderDetail.setPriceEach(50.98);
		orderDetail.setQuantityOrdered(10);
		
		Mockito.when(orderDetailRepository.save(orderDetail)).
		thenReturn(orderDetail);
		assertThat(orderDetailService.getOrderDetailsUsingPaging()).
		isNotNull();
		
	}
	

}