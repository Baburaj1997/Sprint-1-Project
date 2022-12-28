package com.shoppingcart.project.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@Column(name = "employee_Number")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long employeeNumber;
	
	@Column(name = "last_name", nullable = false, length = 255)
	private String lastName;
	
	@Column(name = "first_name", nullable = false, length = 255)
	private String firstName;
	
	@Column(name = "Extension", nullable = false, length = 255)
	private String extension;
	
	@Column(name = "Email", nullable = false, length = 255)
	private String email;
	
	@Column(name = "Office_code", nullable = false, length = 255)
	private String officeCode;
	
	@Column(name = "Reports_to", nullable = false, length = 255)
	private String reportsTo;
	
	@Column(name = "Job_title", nullable = false, length = 255)
	private String jobTitle;
	
	@OneToMany
	@JoinColumn(name="emp_cust_Number")
	private List<Customer> customer;
	
	@OneToMany
	@JoinColumn(name = "Modified_empTable")
	private List<Employee> employee;
	
	@ManyToOne
	@JoinColumn(name="OfficeNo._EmpNo.")
	private Office office;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(long employeeNumber, String lastName, String firstName, String extension, String email,
			String officeCode, String reportsTo, String jobTitle, List<Customer> customer, List<Employee> employee,
			Office office) {
		super();
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
		this.customer = customer;
		this.employee = employee;
		this.office = office;
	}

	public Employee(String lastName, String firstName, String extension, String email, String officeCode,
			String reportsTo, String jobTitle,Office office) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
		this.office = office;
	}

	public long getEmployeenumber() {
		return employeeNumber;
	}

	public void setEmployeenumber(long employeenumber) {
		this.employeeNumber = employeenumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	

	public long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	
	
	public List<Employee> getEmployee() {
		return employee;
	
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public Office getOffice() {
		return office;
	}


	public void setOffice(Office office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "\nEmployee [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", officeCode=" + officeCode + ", reportsTo="
				+ reportsTo + ", jobTitle=" + jobTitle + ", office=" + office + "]";
	}
	


		
}
