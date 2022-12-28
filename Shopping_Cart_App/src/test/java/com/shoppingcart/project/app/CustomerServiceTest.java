package com.shoppingcart.project.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shoppingcart.project.app.Repository.CustomerRepository;
import com.shoppingcart.project.app.model.Customer;
import com.shoppingcart.project.app.service.CustomerService;


@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;
	
	@MockBean
	private CustomerRepository customerRepository;
	
	
	@Test
	public void getAllCustomersTest() {
		Customer customer = new Customer();
		
		customer.setCreditLimit(1L);
		customer.setCustomerName("Robin Decruz");
		customer.setContactFirstName("Robin");
		customer.setContactLastName("Decruz");
		customer.setCountry("France");
		
		Mockito.when(customerRepository.save(customer)).
			thenReturn(customer);
		assertThat(customerService.getAllCustomers()).
			isNotNull();
	}
	
	
	@Test
	public void getCustomerByIdTest() {
		Customer customer = new Customer();
		
		customer.setCreditLimit(1L);
		customer.setCustomerName("Robin Decruz");
		customer.setContactFirstName("Robin");
		customer.setContactLastName("Decruz");
		customer.setCountry("France");
		
		Mockito.when(customerRepository.save(customer)).
			thenReturn(customer);
		assertThat(customerService.getCustomerById(1L)).
			isNotNull();
	
	}

	
	@Test
	public void addCustomerTest() {
		Customer customer = new Customer(1L,"Viraj Kumar","Kumar","Viraj", "6202054997","Hinoo, Ranchi", "Hinoo ,Ranchi",
	 			 "Ranchi","Jharkhand", 834002,"India", 15L, 50L, null, null,null);
		
		Mockito.when(customerRepository.save(customer)).
			thenReturn(customer);
		assertThat(customerService.createCustomer(customer)).
			isEqualTo(customer);
		
	}
	
	
	@Test
	public void deleteCustomerTest() {
		Customer customer = new Customer();
		
		customer.setCreditLimit(1L);
		customer.setCustomerName("Viraj Kumar");
		customer.setContactFirstName("Viraj");
		customer.setContactLastName("Kumar");
		customer.setState("Ranchi");
		customer.setCountry("India");
		
		Mockito.when(customerRepository.save(customer)).
			thenReturn(customer);
		customerService.deleteCustomer(1L);
		assertThat(customerService.getCustomerById(1L)).
			isEmpty();
		}
	
	
	@Test
	void updateCustomerTest() {
		Customer customer = new Customer();
		
		customer.setCreditLimit(1L);
		customer.setCustomerName("Viraj Kumar");
		customer.setContactFirstName("Viraj");
		customer.setContactLastName("Kumar");
		customer.setState("Ranchi");
		customer.setCountry("India");
		
		Mockito.when(customerRepository.save(customer)).
			thenReturn(customer);
		customerService.updateCustomer(customer, 2L);
		assertThat(customerService.getCustomerById(1L)).
			isEmpty();
	}
	
	
	@Test
	void getCustomerSortedByNameTest() {
		Customer customer1 = new Customer();
		
		customer1.setCreditLimit(1L);
		customer1.setCustomerName("Robin Decruz");
		customer1.setContactFirstName("Robin");
		customer1.setContactLastName("Decruz");
		customer1.setCountry("France");
		
		Customer customer2 = new Customer();
		customer2.setCreditLimit(1L);
		customer2.setCustomerName("Zoya Rima");
		customer2.setContactFirstName("Zoya");
		customer2.setContactLastName("Rima");
		customer2.setCountry("India");
		
		Mockito.when(customerRepository.save(customer1)).
			thenReturn(customer1);
		Mockito.when(customerRepository.save(customer2)).
		thenReturn(customer2);
		assertThat(customerService.getCustomerSortedByName()).
			isNotNull();
	}

	

	
	@Test
	void getCustomersUsingPagingTest() {
		Customer customer = new Customer();
		
		customer.setCreditLimit(1L);
		customer.setCustomerName("Robin Decruz");
		customer.setContactFirstName("Robin");
		customer.setContactLastName("Decruz");
		customer.setCountry("France");
		
		Mockito.when(customerRepository.save(customer)).
			thenReturn(customer);
		assertThat(customerService.getCustomersUsingPaging()).
			isNotNull();
	}

	

}

