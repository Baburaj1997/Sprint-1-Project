package com.shoppingcart.project.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;


import com.shoppingcart.project.app.model.Product;

@Component
public interface ProductService {
	

	public List<Product> getAllProducts();
	
	public Optional<Product> getProductById(Long id);
	
	public Product createProduct(Product product);
	
	public void deleteProduct(Long pid);
	
	public void updateProduct(Product product, Long productId);

	public List<Product> findByProductName(String productName);

}
