package com.shoppingcart.project.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.project.app.Repository.ProductLineRepository;
import com.shoppingcart.project.app.model.ProductLine;
import com.shoppingcart.project.app.service.ProductLineService;

@Service
public class ProductLineServiceImpl implements ProductLineService{

	@Autowired
	private ProductLineRepository productLineRepository;
	
	//get all ProductLines
	public List<ProductLine> getAllProductlines(){
		List<ProductLine> list = productLineRepository.findAll();
		return list;
	}
	
	//get single ProductLine by id
	public Optional<ProductLine> getProductLineById(Long id) {
		Optional<ProductLine> productLine = productLineRepository.findById(id);
		return productLine;
	}
	
	//adding the ProductLine
	public ProductLine createProductLine(ProductLine p) {
		ProductLine result = productLineRepository.save(p);
		return result;
	}
	
	//delete ProductLine
	public void deleteProductLine(Long pid) {
		productLineRepository.deleteById(pid);
	}
	
	//update ProductLine
	public void updateProductLine(ProductLine productLine, Long ProductLineId) {
		productLine.setProductLine(ProductLineId);
		productLineRepository.save(productLine);
	}

	@Override
	public List<ProductLine> findAllSortedByDescription() {
		return productLineRepository.findAllSortedBydescription();
	}
	
}
