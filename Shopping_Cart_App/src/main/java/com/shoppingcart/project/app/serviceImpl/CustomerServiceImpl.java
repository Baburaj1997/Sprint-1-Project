package com.shoppingcart.project.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shoppingcart.project.app.Repository.CustomerRepository;
import com.shoppingcart.project.app.model.Customer;
import com.shoppingcart.project.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	//get all Customers
		@Override
		public List<Customer> getAllCustomers() {
			List<Customer> list = customerRepository.findAll();
			return list;
		}

		//get single Customer by id
		@Override
		public Optional<Customer> getCustomerById(Long id) {
			Optional<Customer> customer = customerRepository.findById(id);
			return customer;
		}

		//adding the Customer
		@Override
		public Customer createCustomer(Customer customer) {
			Customer result = customerRepository.save(customer);
			return result;
		}

		//delete the Customer
		@Override
		public void deleteCustomer(Long cid) {
			customerRepository.deleteById(cid);
			
		}

		//update the Customer
		@Override
		public void updateCustomer(Customer customer, Long customerId) {
			customer.setCustomerNumber(customerId);
			customerRepository.save(customer);
			
		}

		//get all Customers sorted by name using query
		@Override
		public List<Customer> getCustomerSortedByName() {
			List<Customer> list = customerRepository.getCustomerSortedByName();
			return list;
		}

		@Override
		public List<Customer> searchByLastName(String contactlastName) {
			return  customerRepository.findByLastName(contactlastName);
		}

		@Override
		public List<Customer> searchByFirstName(String contactfirstName) {
			return  customerRepository.findByFirstName(contactfirstName);
		}

		

		//get all Customers by using paging concept
		@Override
		public List<Customer> getCustomersUsingPaging() {
			Pageable pageable = PageRequest.of(0, 1);
			List<Customer> list = customerRepository.findCustomers(pageable);
			return list;
		}

		

}