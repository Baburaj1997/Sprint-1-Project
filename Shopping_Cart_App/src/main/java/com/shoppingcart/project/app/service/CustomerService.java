package com.shoppingcart.project.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shoppingcart.project.app.model.Customer;


@Component
public interface CustomerService {

public List<Customer> getAllCustomers();
	
	public Optional<Customer> getCustomerById(Long id);
	
	public Customer createCustomer(Customer customer);
	
	public void deleteCustomer(Long cid);
	
	public void updateCustomer(Customer customer, Long customerId);
	
	public List<Customer> searchByLastName(String contactlastName);
	
	public List<Customer> searchByFirstName(String contactfirstName);
	
	
	public List<Customer> getCustomersUsingPaging();

	public List<Customer> getCustomerSortedByName();
}
