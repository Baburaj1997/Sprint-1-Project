package com.shoppingcart.project.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shoppingcart.project.app.Repository.ProductLineRepository;
import com.shoppingcart.project.app.model.ProductLine;
import com.shoppingcart.project.app.service.ProductLineService;

@SpringBootTest
public class ProductLineServiceTest {

	@Autowired
	private ProductLineService productLineService;
	
	@MockBean
	private ProductLineRepository productLineRepository;
	
	@Test
	public void getAllProductlinesTest() {
		ProductLine productLine = new ProductLine();
		
		productLine.setProductLine(1L);
		productLine.setTextDescription("Myanavar is known for the world best ethnic wear for all occassions are available in different prices");
		productLine.setHtmlDescription("<ol><li> Myanavar is famous for weddings clothes</li></ol>");
		productLine.setImage("Kurta.img");
		
		Mockito.when(productLineRepository.save(productLine)).
		thenReturn(productLine);
		assertThat(productLineService.getAllProductlines()).
		isNotNull();	
	}
	
	@Test
	public void getProductLineByIdTest() {
		ProductLine productLine = new ProductLine();
		
		productLine.setProductLine(1L);
		productLine.setTextDescription("Myanavar is known for the world best ethnic wear for all occassions are available in different prices");
		productLine.setHtmlDescription("<ol><li> Myanavar is famous for weddings clothes</li></ol>");
		productLine.setImage("Kurta.img");
		
		Mockito.when(productLineRepository.save(productLine)).
		thenReturn(productLine);
		assertThat(productLineService.getProductLineById(1L)).
		isNotNull();	
	}
	
	@Test
	public void addProductLineTest() {
		ProductLine productLine = new ProductLine();
		
		productLine.setProductLine(1L);
		productLine.setTextDescription("Myanavar is known for the world best ethnic wear for all occassions are available in different prices");
		productLine.setHtmlDescription("<ol><li> Myanavar is famous for weddings clothes</li></ol>");
		productLine.setImage("Kurta.img");
		
		Mockito.when(productLineRepository.save(productLine)).
		thenReturn(productLine);
		assertThat(productLineService.createProductLine(productLine)).
		isEqualTo(productLine);	
	}
	
	@Test
	public void deleteProductLineTest() {
		ProductLine productLine = new ProductLine();
		
		productLine.setProductLine(1L);
		productLine.setTextDescription("Myanavar is known for the world best ethnic wear for all occassions are available in different prices");
		productLine.setHtmlDescription("<ol><li> Myanavar is famous for weddings clothes</li></ol>");
		productLine.setImage("Kurta.img");
		
		Mockito.when(productLineRepository.save(productLine)).
		thenReturn(productLine);
		productLineService.deleteProductLine(1L);
		assertThat(productLineService.getProductLineById(1L)).
		isEmpty();	
	}
	
	@Test
	public void updateProductLineTest() {
		ProductLine productLine = new ProductLine();
		
		productLine.setProductLine(1L);
		productLine.setTextDescription("Myanavar is known for the world best ethnic wear for all occassions are available in different prices");
		productLine.setHtmlDescription("<ol><li> Myanavar is famous for weddings clothes</li></ol>");
		productLine.setImage("Kurta.img");
		
		Mockito.when(productLineRepository.save(productLine)).
		thenReturn(productLine);
		productLineService.updateProductLine(productLine, 2L);
		assertThat(productLineService.getProductLineById(1L)).
		isEmpty();	
	}

	
}