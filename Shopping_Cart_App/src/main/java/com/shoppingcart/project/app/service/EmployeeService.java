package com.shoppingcart.project.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shoppingcart.project.app.model.Employee;

@Component
public interface EmployeeService {

	
public List<Employee> getAllEmployees();

public Optional<Employee> getEmployeeById(Long id);

public Employee createEmployee(Employee employee);

public void deleteEmployee(Long eid);

public void updateEmployee(Employee employee, Long employeeId);

//public List<Employee> getEmployeeSortedByFirstName();

public List<Employee> getEmployeesUsingPaging();

	
}
