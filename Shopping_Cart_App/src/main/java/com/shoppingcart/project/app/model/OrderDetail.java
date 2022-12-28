package com.shoppingcart.project.app.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetails")
public class OrderDetail {

	@Id
	@Column(name = "Order_Number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderNumber;
	
	@Column(name = "Quantity_Ordered")
	private long quantityOrdered;
	
	@Column(name = "Price_Each")
	private double priceEach;

	@Column(name = "OrderLineNumber")
	private long orderLineNumber;
	
	@OneToOne
	@JoinColumn(name="orderdetails_Product_Code")
	private Product product;
	
	@OneToOne(cascade= CascadeType.ALL,mappedBy ="orderdetail" )
	private Order order;
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public OrderDetail(long quantityOrdered, double priceEach, long orderLineNumber, Product product) {
		super();
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
		this.product = product;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public long getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(long quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public long getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(long orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}



	@Override
	public String toString() {
		return "\nOrderDetail [orderNumber=" + orderNumber + ", quantityOrdered=" + quantityOrdered + ", priceEach="
				+ priceEach + ", orderLineNumber=" + orderLineNumber + ", product=" + product + "]";
	}

	
		
}
