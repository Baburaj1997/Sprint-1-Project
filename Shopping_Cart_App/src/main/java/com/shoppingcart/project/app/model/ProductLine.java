package com.shoppingcart.project.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productlines")
public class ProductLine {
	
	@Id
	@Column(name = "Product_Line")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long productLine;
	
	@Column(name = "text_Description",nullable = false, length = 225)
	private String textDescription;
	
	@Column(name = "html_Description",nullable = false, length = 225)
	private String htmlDescription;
	
	@Column(name = "Image",nullable = false, length = 225)
	private String image;
	
	@OneToMany
	@JoinColumn(name = "productlines_Product_Line")
	private List<Product> product;

	public ProductLine() {
		super();
	}

	public ProductLine(long productLine, String textDescription, String htmlDescription, String image,
			List<Product> product) {
		super();
		this.productLine = productLine;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
		this.product = product;
	}
	
	
	public long getProductLine() {
		return productLine;
	}

	public void setProductLine(long productLine) {
		this.productLine = productLine;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "\nProductLine [productLine=" + productLine + ", textDescription=" + textDescription + ", htmlDescription="
				+ htmlDescription + ", image=" + image +  "]";
	}

	
}
