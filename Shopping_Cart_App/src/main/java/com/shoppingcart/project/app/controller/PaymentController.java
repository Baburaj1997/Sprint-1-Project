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

//import com.shoppingcart.project.app.Repository.PaymentRepository;
import com.shoppingcart.project.app.exception.PaymentNotFoundException;
import com.shoppingcart.project.app.model.Payment;
import com.shoppingcart.project.app.service.PaymentService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	/*------------------------------------------------------------------------------
	GET 	 findAll method
	--------------------------------------------------------------------------------
	 */
		//Find all payment
	@GetMapping("payments")
	public ResponseEntity<List<Payment>> getAllPayments() throws PaymentNotFoundException {
		List<Payment> payment = paymentService.getAllPayments();
		
		if(payment.size()<=0) {
			throw new PaymentNotFoundException("Payment not exist");
		}
		return ResponseEntity.of(Optional.of(payment));
	}
	/*------------------------------------------------------------------------------
 	Post 	 Create method
	--------------------------------------------------------------------------------
	 */
		//Add payment
	@PostMapping("payments")
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) throws PaymentNotFoundException {
		Payment p = paymentService.createPayment(payment);
		
		if(p == null) {
			throw new PaymentNotFoundException("Payment not get inserted");
		}
		return ResponseEntity.of(Optional.of(p));
	}
	
	/*------------------------------------------------------------------------------
 	GET 	 GetByID method
	--------------------------------------------------------------------------------
	 */
		//Find payment By Id
	@GetMapping("payments/{id}")
	public ResponseEntity<Payment> getPayment(@PathVariable("id") Long id) throws PaymentNotFoundException  {
		Payment payment = paymentService.getPaymentById(id)
				 .orElseThrow(() -> new PaymentNotFoundException("Payment not exist with id:" + id));
		
		if(payment == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(payment));
	}
	/*------------------------------------------------------------------------------
 	GET 	 sortByAmount method
	--------------------------------------------------------------------------------
	 */
		 //Sort the Payment List by amount
	    @GetMapping("sortbyamount")
	    public List<Payment> findAllSortedByAmpunt(@RequestBody Payment paymentdetails) throws PaymentNotFoundException{
	        return paymentService.findAllSortedByAmount();
	             
	    }
	    
    /*------------------------------------------------------------------------------
 	Put 	 update method
	--------------------------------------------------------------------------------
	 */
		//Update payment
	    @PutMapping("payments/{paymentId}")
		public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment, @PathVariable("employeeId") Long paymentId) throws PaymentNotFoundException {
			
			paymentService.getPaymentById(paymentId)
				.orElseThrow(() -> new PaymentNotFoundException("Payment not exist with id:" + paymentId));
			
			paymentService.updatePayment(payment, paymentId);
			
			return ResponseEntity.ok().body(payment);
		}
	/*------------------------------------------------------------------------------
 	delete 	  method
	--------------------------------------------------------------------------------
	 */
		//Delete By Id 
	    @DeleteMapping("payments/{paymentId}")
		public ResponseEntity<Void> deletePayment(@PathVariable("paymentId") Long paymentId) throws PaymentNotFoundException {
			
			paymentService.getPaymentById(paymentId)
				 .orElseThrow(() -> new PaymentNotFoundException("Payment not exist with id:" + paymentId));
			
			paymentService.deletePayment(paymentId);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}

	}
