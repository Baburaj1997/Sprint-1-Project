package com.shoppingcart.project.app.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.project.app.model.Order;



@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	//native query
	@Query(value = "SELECT * FROM orders ORDER BY order_Date",nativeQuery=true)
	public List<Order> findAllSortedByOrderDate();
	
}
