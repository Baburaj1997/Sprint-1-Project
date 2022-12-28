package com.shoppingcart.project.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shoppingcart.project.app.Repository.EmployeeRepository;
import com.shoppingcart.project.app.model.Employee;
import com.shoppingcart.project.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	//get all Employees
	public List<Employee> getAllEmployees(){
		List<Employee> list = employeeRepository.findAll();
		return list;
	}
			
	//get single Employee by id
	public Optional<Employee> getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee;
	}
			
	//adding the Employee
	public Employee createEmployee(Employee employee) {
		Employee result = employeeRepository.save(employee);
		return result;
	}
			
	//delete the Employee
	public void deleteEmployee(Long eid) {
		employeeRepository.deleteById(eid);
	}
			
	//update the Employee
	public void updateEmployee(Employee employee, Long employeeId) {
		employee.setEmployeeNumber(employeeId);
		employeeRepository.save(employee);
	}

	
	//get all Employees by using paging concept
	@Override
	public List<Employee> getEmployeesUsingPaging() {
		Pageable pageable = PageRequest.of(0, 1);
		List<Employee> list = employeeRepository.findEmployees(pageable);
		return list;
	}
}