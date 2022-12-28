package com.shoppingcart.project.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shoppingcart.project.app.model.OrderDetail;

@Component
public interface OrderDetailService {
	
public List<OrderDetail> getAllOrderDetails();
	
	public Optional<OrderDetail> getOrderDetailById(long id);
	
	public OrderDetail createOrderDetail(OrderDetail od);
	
	public void deleteOrderDetail(long id);
	
	public List<OrderDetail> getOrderDetailsUsingPaging();

	public List<OrderDetail> findAllSortedByPrice();

	public void updateOrderDetail(OrderDetail orderDetail, long orderDetailId);
	
}
