package com.shoppingcart.project.app.Repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.project.app.model.Employee;





@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query(value = "SELECT e FROM Employee e ORDER BY email")
	public List<Employee> findAllSortedByEmail();
	
	@Query(value="select * from Employees  where first_name = ?", nativeQuery=true)
	public List<Employee> findByFirstName(String firstName);
	
	@Query("from Employee" )
	List<Employee> findEmployees(Pageable pageable);
	
}