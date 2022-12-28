package com.shoppingcart.project.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@Column(name = "customer_No.")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerNumber;
	
	@Column(name = "Customer_Name" , nullable = false, length = 225)
	private String customerName;
	
	@Column(name = "contact_LastName" , nullable = false, length = 225)
	private String contactLastName;
	
	@Column(name = "contact_FirstName" , nullable = false, length = 225)
	private String contactFirstName;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "address_Line1" , nullable = false, length = 225)
	private String addressLine1;
	
	@Column(name = "address_Line2" , nullable = false, length = 225)
	private String addressLine2;
	
	@Column(name = "City" , nullable = false, length = 225)
	private String city;
	
	@Column(name = "State" , nullable = false, length = 225)
	private String state;
	
	@Column(name = "postal_Code")
	private long postalCode;
	
	@Column(name = "Country")
	private String country;
	
	@Column(name = "salesRep_EmployeeNumber")
	private long salesRepEmployeeNumber;
	
	@Column(name = "Credit_Limit")
	private long creditLimit;
	
	@OneToMany
	@JoinColumn(name="Order_Number_customer_Number")
	private List<Order> order;
	
	@OneToOne(cascade= CascadeType.ALL,mappedBy ="customer" )
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name="emp_cust_Number")
	private Employee employee;
	
	
	public Customer() {
		super();
		
	}

	public Customer(long customerNumber, String customerName, String contactLastName, String contactFirstName,
			String phone, String addressLine1, String addressLine2, String city, String state, long postalCode,
			String country, long salesRepEmployeeNumber, long creditLimit, List<Order> order, Payment payment,
			Employee employee) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		this.creditLimit = creditLimit;
		this.order = order;
		this.payment = payment;
		this.employee = employee;
	}





	public long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return this.contactFirstName+" "+this.contactLastName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(long postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getSalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}

	public void setSalesRepEmployeeNumber(long salesRepEmployeeNumber) {
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
	}

	public long getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(long creditLimit) {
		this.creditLimit = creditLimit;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrders(List<Order> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "\n Customer [customerNumber=" + customerNumber + ", customerName=" + customerName + ", contactLastName="
				+ contactLastName + ", contactFirstName=" + contactFirstName + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", country=" + country + ", salesRepEmployeeNumber="
				+ salesRepEmployeeNumber + ", creditLimit=" + creditLimit + "]";
	}
		
	
}
