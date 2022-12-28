package com.shoppingcart.project.app.Repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.project.app.model.Office;




@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
	
	@Query(value = "SELECT  off FROM Office off ORDER BY state")
	public List<Office> findAllSortedByState();
	
	@Query(value="select * from Office  where city= ?", nativeQuery=true)
	public List<Office> findByCity(String city);
	
	
	@Query("from Office" )
	List<Office> findOffices(Pageable pageable);
	
}