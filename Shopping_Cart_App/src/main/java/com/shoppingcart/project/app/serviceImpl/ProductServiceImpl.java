package com.shoppingcart.project.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.project.app.Repository.ProductRepository;
import com.shoppingcart.project.app.model.Product;
import com.shoppingcart.project.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	//get all Products
	public List<Product> getAllProducts(){
		List<Product> list = (List<Product>)this.productRepository.findAll();
		return list;
	}
	
	//get single Product by id
	public Optional<Product> getProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product;
	}
	
	//adding the Product
	public Product createProduct(Product p) {
		Product result = productRepository.save(p);
		return result;
	}
	
	//delete Product
	public void deleteProduct(Long pid) {
		productRepository.deleteById(pid);
	}
	
	//update Product
	public void updateProduct(Product product, Long ProductId) {
		product.setProductCode(ProductId);
		productRepository.save(product);
	}

	@Override
	public List<Product> findByProductName(String productName) {
		return productRepository.findByProductName(productName);
	}
	
}
