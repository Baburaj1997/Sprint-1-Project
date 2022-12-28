package com.shoppingcart.project.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@Column(name = "Product_Code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productCode;
	
	@Column(name = "Product_Name",nullable = false, length = 225)
	private String productName;
	
	@Column(name = "Product_Scale",nullable = false, length = 225)
	private String productScale;
	
	@Column(name = "Product_Vendor",nullable = false, length = 225)
	private String productVendor;
	
	@Column(name = "Product_Description",nullable = false, length = 225)
	private String productDescription;
	
	@Column(name = "QuantityInStock")
	private long quantityInStock;
	
	@Column(name = "Buy_Price")
	private double buyPrice;
	
	@Column(name = "MSRP")
	private double msrp;
	
	@ManyToOne
	@JoinColumn(name="productlines_Product_Line")
	private ProductLine productline;
	
	@OneToOne(cascade= CascadeType.ALL,mappedBy ="product" )
	@JoinColumn(name = "orderdetails_Product_Code")
	private OrderDetail orderdetail;
	
	
	public Product() {
		super();
	}

	public Product(long productCode, String productName, String productScale, String productVendor,
			String productDescription, long quantityInStock, double buyPrice, double msrp,
			ProductLine productline, OrderDetail orderdetail) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
		this.productline = productline;
		this.orderdetail = orderdetail;
	}

	public long getProductCode() {
		return productCode;
	}

	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductScale() {
		return productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public long getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(long quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	
	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

	public ProductLine getProductline() {
		return productline;
	}

	public void setProductline(ProductLine productline) {
		this.productline = productline;
	}

	public OrderDetail getOrderdetail() {
		return orderdetail;
	}


	public void setOrderdetail(OrderDetail orderdetail) {
		this.orderdetail = orderdetail;
	}

	@Override
	public String toString() {
		return "\nProduct [productCode=" + productCode + ", productName=" + productName + ", productScale=" + productScale
				+ ", productVendor=" + productVendor + ", productDescription=" + productDescription
				+ ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", msrp=" + msrp
				+ ", productline=" + productline + ", orderdetail=" + orderdetail + "]";
	}

	
}
