package com.shoppingcart.project.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.project.app.exception.EmployeeNotFoundException;
import com.shoppingcart.project.app.model.Employee;
import com.shoppingcart.project.app.service.EmployeeService;



@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	
	/*------------------------------------------------------------------------------
 	GET 	 findAll method
	--------------------------------------------------------------------------------
	 */
	
	@GetMapping("employees")
	public ResponseEntity<List<Employee>> getAllEmployees() throws EmployeeNotFoundException {
		List<Employee> employee = employeeService.getAllEmployees();
		
		if(employee.size()<=0) {
			throw new EmployeeNotFoundException("Employee record is empty");
		}
		return ResponseEntity.of(Optional.of(employee));
	}
	
	/*------------------------------------------------------------------------------
	 	POST 	 CREATE method
	--------------------------------------------------------------------------------
	*/
	@PostMapping("employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException {
		Employee emp = employeeService.createEmployee(employee);
		
		if(emp == null) {
			throw new EmployeeNotFoundException("Employee is not inserted");
		}
		return ResponseEntity.of(Optional.of(emp));
	}
	
	/*------------------------------------------------------------------------------
	 	Get 	getEMPLOYEE by id METHOD
	--------------------------------------------------------------------------------
	*/
		//Find employee By Id
	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) throws EmployeeNotFoundException  {
		Employee employee = employeeService.getEmployeeById(id)
				 .orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id:" + id));
		
		if(employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(employee));
	}
		
	 /*------------------------------------------------------------------------------
	 	POST 	 updateEMPLOYEE method
	--------------------------------------------------------------------------------
	*/
	    
		//Update Employee
	    @PutMapping("employees/{employeeId}")
		public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("employeeId") Long employeeId) throws EmployeeNotFoundException {
			
			employeeService.getEmployeeById(employeeId)
					.orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id:" + employeeId));
			
			employeeService.updateEmployee(employee, employeeId);
			
			return ResponseEntity.ok(employee);
			
		}
	    
	/*------------------------------------------------------------------------------
	 	delete 	
	--------------------------------------------------------------------------------
	*/

		@DeleteMapping("employees/{employeeId}")
		public ResponseEntity<Void> deleteEmployee(@PathVariable("employeeId") Long employeeId) throws EmployeeNotFoundException {
			
			employeeService.getEmployeeById(employeeId)
					.orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id:" + employeeId));
			
			employeeService.deleteEmployee(employeeId);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
	}
