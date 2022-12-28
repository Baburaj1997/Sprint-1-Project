package com.shoppingcart.project.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.project.app.model.Payment;





@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	//native query
	@Query(value = "SELECT * FROM payments ORDER BY amount",nativeQuery=true)
	public List<Payment> findAllSortedByAmount();
	
}