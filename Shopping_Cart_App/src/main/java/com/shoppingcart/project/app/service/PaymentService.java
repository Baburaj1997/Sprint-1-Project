package com.shoppingcart.project.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shoppingcart.project.app.model.Payment;

@Component
public interface PaymentService {
	
public List<Payment> getAllPayments();
	
	public Optional<Payment> getPaymentById(Long id);
	
	public Payment createPayment(Payment payment);
	
	public void deletePayment(Long pid);
	
	public void updatePayment(Payment payment, Long paymentId);

	public List<Payment> findAllSortedByAmount();
	

}
