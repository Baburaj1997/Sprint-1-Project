package com.shoppingcart.project.app.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "payments")
public class Payment {
	@Id
	@Column(name = "customer_Number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerNumber;
	
	@Column(name = "payment_Date")
	private Date paymentDate;
	
	@Column(name = "Amount")
	private double amount;
	
	@OneToOne
	@JoinColumn(name="customer_No._customer_Number")
	private Customer customer;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Payment(long customerNumber, Date paymentDate, double amount, Customer customer) {
		super();
		this.customerNumber = customerNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.customer = customer;
	}

	

	public long getCustomerNumber() {
		return customerNumber;
	}



	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}



	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate( Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public boolean setAmount(double amount) {
		this.amount = amount;
		return true;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "\nPayment [customerNumber=" + customerNumber + ", paymentDate=" + paymentDate + ", amount=" + amount
				+ ", customer=" + customer + "]";
	}


	
	
	
}
