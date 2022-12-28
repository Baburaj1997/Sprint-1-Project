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
@Table(name = "offices")
public class Office {
	
	@Id
	@Column(name = "Office_code")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long officeCode;
	
	@Column(name = "City", nullable = false, length = 255)
	private String city;
	
	@Column(name = "Phone_no.")
	private String phone;
	
	@Column(name = "address_Line1", nullable = false, length = 255)
	private String addressLine1;
	
	@Column(name = "address_Line2", nullable = false, length = 255)
	private String addressLine2;
	
	@Column(name = "State", nullable = false, length = 255)
	private String state;
	
	@Column(name = "Country", nullable = false, length = 255)
	private String country;
	
	@Column(name = "Pin_Code", nullable = false, length = 255)
	private int postalCode;
	
	@Column(name = "Territory", nullable = false, length = 255)
	private String territory;
	
	@OneToMany
	@JoinColumn(name="OfficeNo._EmpNo.")
	private List<Employee> employee;
	
	public Office() {
		super();

	}
	
	public Office(long officeCode, String city, String phone, String addressLine1, String addressLine2, String state,
			String country, int postalCode, String territory, List<Employee> employee) {
		super();
		this.officeCode = officeCode;
		this.city = city;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.territory = territory;
		this.employee = employee;
	}

	public long getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(long officeCode) {
		this.officeCode = officeCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String  getPhone() {
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}
	
	
	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "\nOffices [officeCode=" + officeCode + ", city=" + city + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", state=" + state + ", country=" + country
				+ ", postalCode=" + postalCode + ", territory=" + territory +"]";
	}
	
}
