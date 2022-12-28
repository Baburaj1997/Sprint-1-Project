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

//import com.shoppingcart.project.app.Repository.OrderRepository;
import com.shoppingcart.project.app.exception.OrderNotFoundException;
import com.shoppingcart.project.app.model.Order;
import com.shoppingcart.project.app.service.OrderService;



@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/orders/")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	/*------------------------------------------------------------------------------
 	GET 	 findAll method
	--------------------------------------------------------------------------------
	 */
		//Find All
	@GetMapping("orders")
	public ResponseEntity<List<Order>> getAllOrders() throws OrderNotFoundException {
		List<Order> order = orderService.getAllOrders();
		
		if(order.size()<=0) {
			throw new OrderNotFoundException("Orders record is empty");
		}
		return ResponseEntity.of(Optional.of(order));
	}
	
	/*------------------------------------------------------------------------------
 	POST 	 create method
	--------------------------------------------------------------------------------
	 */
		//Add Order
	@PostMapping("orders")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) throws OrderNotFoundException {
		Order o = orderService.createOrder(order);
		
		if(o == null) {
			throw new OrderNotFoundException("Order not get inserted");
		}
		return ResponseEntity.of(Optional.of(o));
	}
	
	/*------------------------------------------------------------------------------
 	GET 	 findByid method
	--------------------------------------------------------------------------------
	 */
		//Find By Id
		@GetMapping("orders/{id}")
		public ResponseEntity<Order> getOrder(@PathVariable("id") Long id) throws OrderNotFoundException  {
			Order order = orderService.getOrderById(id)
					 .orElseThrow(() -> new OrderNotFoundException("Order not exist with id:" + id));
			
			if(order == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(order));
		}
		
	/*------------------------------------------------------------------------------
 	GET 	 sortBYdate method
	--------------------------------------------------------------------------------
	*/	
				/*	//Sort the Order List by date
				    @GetMapping("sortbydate")
				    public List<Order> findAllSortedByOrderDate(@RequestBody  Order  orderDetails) throws OrderNotFoundException{
				        return orderService.findAllSortedByOrderDate();
				             
				    }
				  */  
    /*------------------------------------------------------------------------------
 	PUT 	 Update method
	--------------------------------------------------------------------------------
	 */	
		//Update Order
	    @PutMapping("orders/{orderId}")
		public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable("orderId") Long orderId) throws OrderNotFoundException {
			
			orderService.getOrderById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Order not exist with id:" + orderId));
			
			orderService.updateOrder(order, orderId);
			
			return ResponseEntity.ok().body(order);
		}
	/*------------------------------------------------------------------------------
 	Delete 	 method
	--------------------------------------------------------------------------------
	 */   
		//Delete By Id
	    @DeleteMapping("orders/{orderId}")
		public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") Long orderId) throws OrderNotFoundException {
			
			orderService.getOrderById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Order not exist with id:" + orderId));
			
			orderService.deleteOrder(orderId);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
	}