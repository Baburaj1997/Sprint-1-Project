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

//import com.shoppingcart.project.app.Repository.ProductRepository;
import com.shoppingcart.project.app.exception.ProductNotFoundException;
import com.shoppingcart.project.app.model.Product;
import com.shoppingcart.project.app.service.ProductService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/products/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/*------------------------------------------------------------------------------
 	GET 	 findAll method
	--------------------------------------------------------------------------------
	 */
		//Find all
	@GetMapping("products")
	public ResponseEntity<List<Product>> getAllProducts() throws ProductNotFoundException {
		List<Product> product = productService.getAllProducts();
		
		if(product.size()<=0) {
			throw new ProductNotFoundException("Product not exist");
		}
		return ResponseEntity.of(Optional.of(product));
	}
	
	/*------------------------------------------------------------------------------
 	POST 	 Create method
	--------------------------------------------------------------------------------
	 */	
		//Add Product
	@PostMapping("products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) throws ProductNotFoundException {
		Product p = productService.createProduct(product);
		
		if(p == null) {
			throw new ProductNotFoundException("Product not get inserted");
		}
		return ResponseEntity.of(Optional.of(p));
	}
	
	/*------------------------------------------------------------------------------
 	GET 	 GetByID method
	--------------------------------------------------------------------------------
	 */	
		
		//Find By Id
	@GetMapping("products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws ProductNotFoundException  {
		Product product = productService.getProductById(id)
				 .orElseThrow(() -> new ProductNotFoundException("Product not exist with id:" + id));
		
		if(product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(product));
	}
	    
    /*------------------------------------------------------------------------------
 	GET 	 findByProductName method
	--------------------------------------------------------------------------------
	 */
	  //Find by product name
	    @GetMapping("find/{productName}")
	    public ResponseEntity<List<Product>> findByProductName(@PathVariable  String productName){
	    	  List<Product> products = productService.findByProductName(productName);

	    	    if ( products.isEmpty()) {
	    	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    	    }
	    	    
	    	    return new ResponseEntity<>( products, HttpStatus.OK);
	    	  }
    
    
    /*------------------------------------------------------------------------------
 	PUT 	 Update method
	--------------------------------------------------------------------------------
	 */
	    //Update Product
	    @PutMapping("products/{productId}")
		public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("productId") Long productId) throws ProductNotFoundException {
			
			productService.getProductById(productId)
				 .orElseThrow(() -> new ProductNotFoundException("Product not exist with id:" + productId));
			
			productService.updateProduct(product, productId);
			return ResponseEntity.ok(product);
			
		}
    /*------------------------------------------------------------------------------
 	DELETE 	  method
	--------------------------------------------------------------------------------
	 */    
	    //Delete By Id
	    @DeleteMapping("products/{productId}")
		public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {
			
			productService.getProductById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product not exist with id:" + productId));
			
			productService.deleteProduct(productId);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
	}
