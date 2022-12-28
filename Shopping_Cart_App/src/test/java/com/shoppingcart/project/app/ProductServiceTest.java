package com.shoppingcart.project.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shoppingcart.project.app.Repository.ProductRepository;
import com.shoppingcart.project.app.model.Product;
import com.shoppingcart.project.app.service.ProductService;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	
	@Test
	public void getAllProductsTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Tea");
		product.setProductScale("available in all price");
		product.setProductVendor("ApnaTea");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.getAllProducts()).
		isNotNull();	
	}
	
	@Test
	public void getProductByIdTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Tea");
		product.setProductScale("available in all price");
		product.setProductVendor("ApnaTea");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.getProductById(1L)).
		isNotNull();	
	}

	@Test
	public void addProductTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Tea");
		product.setProductScale("available in all price");
		product.setProductVendor("ApnaTea");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.createProduct(product)).
		isEqualTo(product);
	}

	@Test
	public void deleteProductTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Tea");
		product.setProductScale("available in all price");
		product.setProductVendor("ApnaTea");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		productService.deleteProduct(1L);
		assertThat(productService.getProductById(1L)).
		isEmpty();	
	}
	
	@Test
	public void updateProductTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Tea");
		product.setProductScale("available in all price");
		product.setProductVendor("ApnaTea");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		productService.updateProduct(product, 2L);
		assertThat(productService.getProductById(1L)).
		isEmpty();	
	}

	
}