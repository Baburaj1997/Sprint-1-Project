package com.shoppingcart.project.app.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.project.app.model.ProductLine;


@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, Long> {
	
	//native query
	@Query(value = "SELECT * FROM productLines ORDER BY text_description",nativeQuery=true)
	public List<ProductLine> findAllSortedBydescription();

}
