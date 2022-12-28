package com.shoppingcart.project.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shoppingcart.project.app.Repository.OrderDetailRepository;
import com.shoppingcart.project.app.model.OrderDetail;
import com.shoppingcart.project.app.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	//get all OrderDetails
	public List<OrderDetail> getAllOrderDetails(){
		List<OrderDetail> list = orderDetailRepository.findAll();
		return list;
	}
	
	//get single OrderDetail by id
	public Optional<OrderDetail> getOrderDetailById(long orderDetailId) {
		Optional<OrderDetail> orderDetail = orderDetailRepository.findById(orderDetailId);
		return orderDetail;
	}
	
	//adding the OrderDetail
	public OrderDetail createOrderDetail(OrderDetail orderDetail) {
		OrderDetail result = orderDetailRepository.save(orderDetail);
		return result;
	}
	
	//delete OrderDetail
	public void deleteOrderDetail(long id) {
		orderDetailRepository.deleteById(id);
	}
	
	//update OrderDetail
	public void updateOrderDetail(OrderDetail orderDetail, long orderDetailId) {
		orderDetail.setOrderNumber(orderDetailId);
		orderDetailRepository.save(orderDetail);
	}

	//get all OrderDetail sorted by quantity using query
	@Override
	public List<OrderDetail> findAllSortedByPrice() {
		List<OrderDetail> list = orderDetailRepository.findAllSortedByPrice();
		return list;
	}
	

	//get all OrderDetail by using paging concept
	@Override
	public List<OrderDetail> getOrderDetailsUsingPaging() {
		Pageable pageable = PageRequest.of(0, 1);
		List<OrderDetail> list = orderDetailRepository.findOrderDetails(pageable);
		return list;
	}
}
