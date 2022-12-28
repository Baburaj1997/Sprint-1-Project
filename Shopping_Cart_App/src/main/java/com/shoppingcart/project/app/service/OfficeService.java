package com.shoppingcart.project.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shoppingcart.project.app.model.Office;

@Component
public interface OfficeService {
	
	public List<Office> getAllOffices();
	
	public Optional<Office> getOfficeById(Long id);
	
	public Office createOffice(Office office);
	
	public void deleteOffice(Long oid);
	
	public void updateOffice(Office office, Long officeId);
	
	public List<Office> getOfficesUsingPaging();

}
