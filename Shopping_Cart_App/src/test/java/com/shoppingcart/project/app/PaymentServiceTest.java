package com.shoppingcart.project.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shoppingcart.project.app.Repository.PaymentRepository;
import com.shoppingcart.project.app.model.Payment;
import com.shoppingcart.project.app.service.PaymentService;

@SpringBootTest
public class PaymentServiceTest {

	@Autowired
	private PaymentService paymentService;
	
	@MockBean
	private PaymentRepository paymentRepository;
	
	@Test
	public void getAllPaymentsTest() {
		Payment  payment = new Payment();
		
		payment.setCustomerNumber(1L);
		payment.setAmount(500.765);
		payment.setPaymentDate(new Date(2022, 12, 10));
		
		Mockito.when(paymentRepository.save(payment)).
		thenReturn(payment);
		assertThat(paymentService.getAllPayments()).
		isNotNull();
	}
	
	@Test
	public void getPaymentByIdTest() {
		Payment  payment = new Payment();
		
		payment.setCustomerNumber(1L);
		payment.setAmount(500.765);
		payment.setPaymentDate(new Date(2022, 12, 10));
		
		Mockito.when(paymentRepository.save(payment)).
		thenReturn(payment);
		assertThat(paymentService.getPaymentById(1L)).
		isNotNull();
	}
	
	@Test
	public void addPaymentTest() {
		Payment  payment = new Payment();
		
		payment.setCustomerNumber(1L);
		payment.setAmount(500.765);
		payment.setPaymentDate(new Date(2022, 12, 10));
		
		Mockito.when(paymentRepository.save(payment)).
		thenReturn(payment);
		assertThat(paymentService.createPayment(payment)).
		isEqualTo(payment);
	}
	
	@Test
	public void deletePaymentTest() {
		Payment  payment = new Payment();
		
		payment.setCustomerNumber(1L);
		payment.setAmount(500.765);
		payment.setPaymentDate(new Date(2022, 12, 10));
		
		Mockito.when(paymentRepository.save(payment)).
		thenReturn(payment);
		paymentService.deletePayment(1L);
		assertThat(paymentService.getPaymentById(1L)).
		isEmpty();
	}
	
	@Test
	public void updatePaymentTest() {
		Payment  payment = new Payment();
		
		payment.setCustomerNumber(1L);
		payment.setAmount(500.765);
		payment.setPaymentDate(new Date(2022, 12, 10));
		
		Mockito.when(paymentRepository.save(payment)).
		thenReturn(payment);
		paymentService.updatePayment(payment, 2L);
		assertThat(paymentService.getPaymentById(1L)).
		isEmpty();
	}

}