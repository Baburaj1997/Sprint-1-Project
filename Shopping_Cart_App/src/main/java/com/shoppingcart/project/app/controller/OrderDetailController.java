package com.shoppingcart.project.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.shoppingcart.project.app.Repository.OrderDetailRepository;
import com.shoppingcart.project.app.exception.OrderDetailNotFoundException;
import com.shoppingcart.project.app.model.OrderDetail;
import com.shoppingcart.project.app.service.OrderDetailService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/orderDetails/")
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;
	
	/*------------------------------------------------------------------------------
 	GET 	 findAll method
	--------------------------------------------------------------------------------
	 */
		//Find all
	@GetMapping("orderdetails")
	public ResponseEntity<List<OrderDetail>> getAllOrderDetails() throws OrderDetailNotFoundException {
		List<OrderDetail> orderDetail = orderDetailService.getAllOrderDetails();
		
		if(orderDetail.size()<=0) {
			throw new OrderDetailNotFoundException("OrderDetail not exist");
		}
		return ResponseEntity.of(Optional.of(orderDetail));
	}
	
	/*------------------------------------------------------------------------------
 	Post 	 create method
	--------------------------------------------------------------------------------
	 */
	
		//Add OrderDetail
	@PostMapping("orderdetails")
	public ResponseEntity<OrderDetail> createOrderDetails(@RequestBody OrderDetail orderDetail) throws OrderDetailNotFoundException {
		OrderDetail o = orderDetailService.createOrderDetail(orderDetail);
		
		if(o == null) {
			throw new OrderDetailNotFoundException("OrderDetail not get inserted");
		}
		return ResponseEntity.of(Optional.of(o));
	}
	
	/*------------------------------------------------------------------------------
 	GET 	 findByID method
	--------------------------------------------------------------------------------
	 */
	
		//Find By Id
	@GetMapping("orderdetails/{id}")
	public ResponseEntity<OrderDetail> getOrderDetail(@PathVariable("id") Long id) throws OrderDetailNotFoundException  {
		OrderDetail orderDetail = orderDetailService.getOrderDetailById(id)
				 .orElseThrow(() -> new OrderDetailNotFoundException("OrderDetail not exist with id:" + id));
		
		if(orderDetail == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(orderDetail));
	}
	
	/*------------------------------------------------------------------------------
 	GET 	 sortByPrice method
	--------------------------------------------------------------------------------
	 */
		//Sort the Order List by date
	    @GetMapping("sortbyprice")
	    public List<OrderDetail> findAllSortedByPrice(@RequestBody  OrderDetail  orderDetails) throws OrderDetailNotFoundException{
	        return orderDetailService.findAllSortedByPrice();
	             
	    }
    /*------------------------------------------------------------------------------
 	Put 	 Update method
	--------------------------------------------------------------------------------
	 */
		//Update orderDetail
	    @PutMapping("orderdetails/{orderDetailId}")
		public ResponseEntity<OrderDetail> updateOrderDetails(@RequestBody OrderDetail orderDetail, @PathVariable("orderDetailId") Long orderDetailId) throws OrderDetailNotFoundException {
			
			orderDetailService.getOrderDetailById(orderDetailId)
					 .orElseThrow(() -> new OrderDetailNotFoundException("OrderDetail not exist with id:" + orderDetailId));
			
			orderDetailService.updateOrderDetail(orderDetail, orderDetailId);
			
			return ResponseEntity.ok(orderDetail);
			
		}
	    
	/*------------------------------------------------------------------------------
 	delete 	 method
	--------------------------------------------------------------------------------
	 */
		//Delete By id
		//delete OrderDetail handler
		@DeleteMapping("orderdetails/{orderdetailId}")
		public ResponseEntity<Void> deleteOrderDetail(@PathVariable("orderdetailId") Long orderdetailId) throws OrderDetailNotFoundException {
			
			orderDetailService.getOrderDetailById(orderdetailId)
					 .orElseThrow(() -> new OrderDetailNotFoundException("OrderDetail not exist with id:" + orderdetailId));
			
			orderDetailService.deleteOrderDetail(orderdetailId);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
	
	}
