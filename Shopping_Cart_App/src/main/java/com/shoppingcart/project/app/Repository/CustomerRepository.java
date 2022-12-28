package com.shoppingcart.project.app.Repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.project.app.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	

	@Query(value = "SELECT * FROM customers ORDER BY customer_name",nativeQuery=true)
	public List<Customer> getCustomerSortedByName();

	@Query(value = "SELECT * FROM customers where contact_last_name=?1",nativeQuery=true)
	public List<Customer> findByLastName(String contactlastName);

	@Query(value = "SELECT * FROM customers where  contact_first_name= ?1",nativeQuery=true)
	public List<Customer> findByFirstName(String contactfirstName);

	@Query("from Customer")
	public List<Customer> findCustomers(Pageable pageable);

	
}