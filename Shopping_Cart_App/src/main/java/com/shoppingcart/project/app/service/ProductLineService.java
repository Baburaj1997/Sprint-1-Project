package com.shoppingcart.project.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shoppingcart.project.app.model.ProductLine;

@Component
public interface ProductLineService {
	
	public List<ProductLine> getAllProductlines();
	
	public Optional<ProductLine> getProductLineById(Long id);
	
	public ProductLine createProductLine(ProductLine productLine);
	
	public void deleteProductLine(Long pid);
	
	public void updateProductLine(ProductLine productLine, Long ProductLineId);

	public List<ProductLine> findAllSortedByDescription();
	
}
