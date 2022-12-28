package com.shoppingcart.project.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shoppingcart.project.app.Repository.EmployeeRepository;
import com.shoppingcart.project.app.model.Employee;
import com.shoppingcart.project.app.service.EmployeeService;


@SpringBootTest
public class EmployeeServiceTest {


	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@Test
	public void getAllEmployeesTest() {
		Employee employee = new Employee();
		
		employee.setEmployeeNumber(1L);
		employee.setFirstName("Viraj");
		employee.setLastName("Kumar");
		employee.setExtension("Full Time");
		employee.setJobTitle("Programmer");
		employee.setEmail("Viraj123@gmail.com");
		employee.setOfficeCode("INFOTECH12");
		
		Mockito.when(employeeRepository.save(employee)).
		thenReturn(employee);
		assertThat(employeeService.getAllEmployees()).
		isNotNull();
	}
	
	@Test
	public void getEmployeeByIdTest() {
		Employee employee = new Employee();
		
		employee.setEmployeeNumber(1L);
		employee.setFirstName("Viraj");
		employee.setLastName("Kumar");
		employee.setExtension("Full Time");
		employee.setJobTitle("Programmer");
		employee.setEmail("Viraj123@gmail.com");
		employee.setOfficeCode("INFOTECH12");
		
		Mockito.when(employeeRepository.save(employee)).
		thenReturn(employee);
		assertThat(employeeService.getEmployeeById(1L)).
		isNotNull();
	}
	
	@Test
	public void addEmployeeTest() {
		Employee employee = new Employee();
		
		employee.setEmployeeNumber(1L);
		employee.setFirstName("Viraj");
		employee.setLastName("Kumar");
		employee.setExtension("Full Time");
		employee.setJobTitle("Programmer");
		employee.setEmail("Viraj123@gmail.com");
		employee.setOfficeCode("INFOTECH12");
		
		Mockito.when(employeeRepository.save(employee)).
		thenReturn(employee);
		assertThat(employeeService.createEmployee(employee)).
		isEqualTo(employee);
		
	}
	
	@Test
	public void deleteEmployeeTest() {
		Employee employee = new Employee();
		
		employee.setEmployeeNumber(1L);
		employee.setFirstName("Viraj");
		employee.setLastName("Kumar");
		employee.setExtension("Full Time");
		employee.setJobTitle("Programmer");
		employee.setEmail("Viraj123@gmail.com");
		employee.setOfficeCode("INFOTECH12");
		
		Mockito.when(employeeRepository.save(employee)).
		thenReturn(employee);
		employeeService.deleteEmployee(1L);
		assertThat(employeeService.getEmployeeById(1L)).
		isEmpty();

	}
	
	@Test
	public void updateEmployeeTest() {
		Employee employee = new Employee();
		
		employee.setEmployeeNumber(1L);
		employee.setFirstName("Viraj");
		employee.setLastName("Kumar");
		employee.setExtension("Full Time");
		employee.setJobTitle("Programmer");
		employee.setEmail("Viraj123@gmail.com");
		employee.setOfficeCode("INFOTECH12");
		
		Mockito.when(employeeRepository.save(employee)).
		thenReturn(employee);
		employeeService.updateEmployee(employee, 2L);
		assertThat(employeeService.getEmployeeById(1L)).
		isEmpty();

	}
/*	
	@Test
	public void getEmployeeSortedByFirstNameTest() {
		Employee employee1 = new Employee();
		
		employee1.setEmployeeNumber(1L);
		employee1.setFirstName("Viraj");
		employee1.setLastName("Kumar");
		employee1.setExtension("Full Time");
		employee1.setJobTitle("Programmer");
		employee1.setEmail("Viraj123@gmail.com");
		employee1.setOfficeCode("INFOTECH12");
		
		Employee employee2 = new Employee();
		
		employee2.setEmployeeNumber(1L);
		employee2.setFirstName("Amit");
		employee2.setLastName("Diwedi");
		employee2.setExtension("Part Time");
		employee2.setJobTitle("Data Analyser");
		employee2.setEmail("Ami103@gmail.com");
		employee2.setOfficeCode("CAPGTECH12");
		
		Mockito.when(employeeRepository.save(employee1)).
		thenReturn(employee1);
		Mockito.when(employeeRepository.save(employee2)).
		thenReturn(employee2);
		assertThat(employeeService.getEmployeeSortedByFirstName()).
		isNotNull();

	}
	*/
	
	
	
	@Test
	public void getEmployeesUsingPagingTest() {
		Employee employee1 = new Employee();
		
		employee1.setEmployeeNumber(1L);
		employee1.setFirstName("Viraj");
		employee1.setLastName("Kumar");
		employee1.setExtension("Full Time");
		employee1.setJobTitle("Programmer");
		employee1.setEmail("Viraj123@gmail.com");
		employee1.setOfficeCode("INFOTECH12");
		
		Employee employee2 = new Employee();
		
		employee2.setEmployeeNumber(1L);
		employee2.setFirstName("Sakshi");
		employee2.setLastName("Diwedi");
		employee2.setExtension("Part Time");
		employee2.setJobTitle("Data Analyser");
		employee2.setEmail("Sak103@gmail.com");
		employee2.setOfficeCode("CAPGTECH12");
		
		Mockito.when(employeeRepository.save(employee1)).
		thenReturn(employee1);
		Mockito.when(employeeRepository.save(employee2)).
		thenReturn(employee2);
		assertThat(employeeService.getEmployeesUsingPaging()).
		isNotNull();

	}
	
	
	
}

