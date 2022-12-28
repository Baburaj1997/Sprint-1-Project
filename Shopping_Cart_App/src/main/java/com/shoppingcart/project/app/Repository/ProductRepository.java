package com.shoppingcart.project.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.project.app.model.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	/*@Query(value = "SELECT p FROM Product p WHERE p.productName =?1")
	List<Product> findByProductName(String productName);*/
	
	@Query(value = "SELECT * FROM Products  WHERE product_name =?",nativeQuery=true)
	List<Product> findByProductName(String productName);
	
	
	@Query(value = "SELECT p FROM Product p ORDER BY Buy_Price")
	public List<Product> findAllSortedByPrice();		  
	   
	@Query(value = "SELECT p FROM Product p ORDER BY Product_Name")
	public List<Product> findAllSortedByName();
	   

} 