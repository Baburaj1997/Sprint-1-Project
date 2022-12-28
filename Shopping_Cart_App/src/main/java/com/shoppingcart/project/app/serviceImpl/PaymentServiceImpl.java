package com.shoppingcart.project.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.project.app.Repository.PaymentRepository;
import com.shoppingcart.project.app.model.Payment;
import com.shoppingcart.project.app.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	//get all Payments
	public List<Payment> getAllPayments(){
		List<Payment> list = paymentRepository.findAll();
		return list;
	}
		
	//get single Payment by id
	public Optional<Payment> getPaymentById(Long id) {
		Optional<Payment> payment = paymentRepository.findById(id);
		return payment;
	}
		
	//adding the Payment
	public Payment createPayment(Payment payment) {
		Payment result = paymentRepository.save(payment);
		return result;
	}
		
	//delete the Payment
	public void deletePayment(Long pid) {
		paymentRepository.deleteById(pid);
	}
		
	//update the Payment
	public void updatePayment(Payment payment, Long paymentId) {
		payment.setCustomerNumber(paymentId);
		paymentRepository.save(payment);
	}

	@Override
	public List<Payment> findAllSortedByAmount() {
		
		return paymentRepository.findAllSortedByAmount();
	}
	
}