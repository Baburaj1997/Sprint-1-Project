package com.shoppingcart.project.app.Repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.project.app.model.OrderDetail;




@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
	
	//native query
	@Query(value = "SELECT * FROM orderdetails  ORDER BY price_each",nativeQuery=true)
	public List<OrderDetail> findAllSortedByPrice();

	@Query("from OrderDetail")
	public List<OrderDetail> findOrderDetails(Pageable pageable);
	 

}
