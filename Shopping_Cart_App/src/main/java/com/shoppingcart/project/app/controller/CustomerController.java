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


import com.shoppingcart.project.app.exception.CustomerNotFoundException;
import com.shoppingcart.project.app.model.Customer;
import com.shoppingcart.project.app.service.CustomerService;




@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/customers/")

public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	/*---------------------------------------------------------------------------------
	GET		findAll method
	-----------------------------------------------------------------------------------
	 */
	
	//get all Customer handler
		@GetMapping("customers")
		public ResponseEntity<List<Customer>> getAllCustomers() throws CustomerNotFoundException {
			List<Customer> customer = customerService.getAllCustomers();
			
			if(customer.size()<=0) {
				throw new CustomerNotFoundException("Customer record is empty");
			}
			return ResponseEntity.of(Optional.of(customer));
		}
	/*---------------------------------------------------------------------------------
		 Post method
	-----------------------------------------------------------------------------------
	*/
		@PostMapping("customers")
		public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
			Customer c = customerService.createCustomer(customer);
			
			if(c == null) {
				throw new CustomerNotFoundException("Customer not get inserted");
			}
				return ResponseEntity.of(Optional.of(c));
		}
		
	/*---------------------------------------------------------------------------------
		GET BY ID
	-----------------------------------------------------------------------------------
	*/
		@GetMapping("customers/{id}")
		public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) throws CustomerNotFoundException  {
			Customer customer = customerService.getCustomerById(id)
					 .orElseThrow(() -> new CustomerNotFoundException("Customer not exist with id:" + id));
			
			if(customer == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(customer));
		}
		
	/*---------------------------------------------------------------------------------
		GET BY LAST NAME
	-----------------------------------------------------------------------------------
	*/  
	    @GetMapping("{contactlastName}")//change to ln 
		public List<Customer> searchByLastName(@PathVariable String contactlastName){
			return customerService.searchByLastName(contactlastName);
		}
	/*----------------------------------------------------------------------------------
		GET BY FIRST NAME
	------------------------------------------------------------------------------------
	*/  
	    @GetMapping("{contactfirsttName}")
		public List<Customer> searchByFirstName(@PathVariable String contactfirstName){
			return customerService.searchByFirstName(contactfirstName);
		}
		
	/*----------------------------------------------------------------------------------
		GET sortByName method
	------------------------------------------------------------------------------------
	*/ 
	    
		//Sorted  Customer List
		@GetMapping("sortbyname")
	    public List<Customer> findAllSortedByName(@RequestBody Customer customerdetails) throws CustomerNotFoundException{
	        return customerService.getCustomerSortedByName();
	             
	    }
		
	/*----------------------------------------------------------------------------------
		PUT update method
	------------------------------------------------------------------------------------
	*/ 

		@PutMapping("customers/{customerId}")
		public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("customerId") Long customerId) throws CustomerNotFoundException {
			
			customerService.getCustomerById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not exist with id:" + customerId));
			
			customerService.updateCustomer(customer, customerId);
			
			return ResponseEntity.ok().body(customer);
			
		}
		
	/*----------------------------------------------------------------------------------
		Delete method
	------------------------------------------------------------------------------------
	*/ 
		//Delete customer
		@DeleteMapping("customers/{customerId}")
		public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") Long customerId) throws CustomerNotFoundException {
			
			customerService.getCustomerById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not exist with id:" + customerId));

			customerService.deleteCustomer(customerId);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
	}
