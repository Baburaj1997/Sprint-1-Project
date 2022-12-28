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

//import com.shoppingcart.project.app.Repository.ProductLineRepository;
import com.shoppingcart.project.app.exception.ProductLineNotFoundException;
import com.shoppingcart.project.app.model.ProductLine;
import com.shoppingcart.project.app.service.ProductLineService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/productLines/")
public class ProductLineController {
	
	@Autowired
	private ProductLineService productLineService;
	
	/*------------------------------------------------------------------------------
 	GET 	 findAll method
	--------------------------------------------------------------------------------
	 */
	
	//Find all ProductLines
	@GetMapping("productlines")
	public ResponseEntity<List<ProductLine>> getAllProductLines() throws ProductLineNotFoundException {
		List<ProductLine> productLine = productLineService.getAllProductlines();
		
		if(productLine.size()<=0) {
			throw new ProductLineNotFoundException("ProductLine not exist");
		}
		return ResponseEntity.of(Optional.of(productLine));
	}
	
	/*------------------------------------------------------------------------------
	POST 	 Create method
	--------------------------------------------------------------------------------
	 */
	//Add ProductLine
	@PostMapping("productlines")
	public ResponseEntity<ProductLine> createProductLine(@RequestBody ProductLine productLine) throws ProductLineNotFoundException {
		ProductLine p = productLineService.createProductLine(productLine);
		
		if(p == null) {
			throw new ProductLineNotFoundException("ProductLine not get inserted");
		}
		return ResponseEntity.of(Optional.of(p));
	}
	/*------------------------------------------------------------------------------
 	GET 	 findByID method
	--------------------------------------------------------------------------------
	 */
	
	//Find By Id
	@GetMapping("productlines/{id}")
	public ResponseEntity<ProductLine> getProductLine(@PathVariable("id") Long id) throws ProductLineNotFoundException  {
		ProductLine productLine = productLineService.getProductLineById(id)
				 .orElseThrow(() -> new ProductLineNotFoundException("ProductLine not exist with id:" + id));
		
		if(productLine == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(productLine));
	}
	
	/*------------------------------------------------------------------------------
 	GET 	 SortByDescription method
	--------------------------------------------------------------------------------
	 */
	
	//Sort the ProductLine by name
    @GetMapping("sortbyname")
    public List<ProductLine> findAllSortedByDescription(@RequestBody ProductLine productLinedetails) throws ProductLineNotFoundException {
        return productLineService.findAllSortedByDescription();
             
    }
    /*------------------------------------------------------------------------------
 	PUT 	 Update method
	--------------------------------------------------------------------------------
	 */
    
    //Update Product
    @PutMapping("productlines/{productLineId}")
	public ResponseEntity<ProductLine> updateProductLine(@RequestBody ProductLine productLine, @PathVariable("productLineId") Long productLineId) throws ProductLineNotFoundException {
		
		productLineService.getProductLineById(productLineId)
			.orElseThrow(() -> new ProductLineNotFoundException("ProductLine not exist with id:" + productLineId));
		
		productLineService.updateProductLine(productLine, productLineId);
		
		return ResponseEntity.ok().body(productLine);
		
	}
	
	 /*------------------------------------------------------------------------------
	 DELETE 	 findAll method
		--------------------------------------------------------------------------------
	 */
	 
	 	//Delete By Id
	 @DeleteMapping("productlines/{productLineId}")
		public ResponseEntity<Void> deleteProductLine(@PathVariable("productLineId") Long productLineId) throws ProductLineNotFoundException {
			
			productLineService.getProductLineById(productLineId)
				.orElseThrow(() -> new ProductLineNotFoundException("ProductLine not exist with id:" + productLineId));
			
			productLineService.deleteProductLine(productLineId);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
}