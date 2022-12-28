package com.shoppingcart.project.app.model;

import java.util.Date;

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
@Table(name = "orders")
public class Order {
	@Id
	@Column(name = "order_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderNumber;

	@Column(name = "order_Date")
	private Date orderDate;
	
	@Column(name = "required_Date")
	private Date requiredDate;
	
	@Column(name = "shipped_Date")
	private Date shippedDate;
	
	@Column(name = "Status" , nullable = false, length = 225)
	private boolean status;
	
	@Column(name = "Comments" , nullable = false, length = 225)
	private String comments;
	
	@OneToOne
	@JoinColumn(name="Order_Number")
	private OrderDetail orderdetail;
	
	@ManyToOne
	@JoinColumn(name="Order_Number_customer_Number")
	private Customer customer;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Date orderDate, Date requiredDate, Date shippedDate, boolean status, String comments,
			OrderDetail orderdetail, Customer customer) {
		super();
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.orderdetail = orderdetail;
		this.customer = customer;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate( Date orderDate) {
		this.orderDate = orderDate;
	}

	public  Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate( Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public  Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate( Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomers(Customer customer) {
		this.customer = customer;
	}


	public OrderDetail getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetails(OrderDetail orderdetail) {
		this.orderdetail = orderdetail;
	}


	@Override
	public String toString() {
		return "\nOrder [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", status=" + status + ", comments=" + comments + ", orderdetail="
				+ orderdetail + ", customer=" + customer + "]";
	}
	
}
