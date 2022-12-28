package com.shoppingcart.project.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shoppingcart.project.app.Repository.OfficeRepository;
import com.shoppingcart.project.app.model.Office;
import com.shoppingcart.project.app.service.OfficeService;

@Service
public class OfficeServiceImpl implements OfficeService{

	@Autowired
	private OfficeRepository officeRepository;
	
	//get all Offices
	@Override
	public List<Office> getAllOffices() {
		List<Office> list = officeRepository.findAll();
		return list;
		
	}

	//get single Office by id
	@Override
	public Optional<Office> getOfficeById(Long id) {
		Optional<Office> office = officeRepository.findById(id);
		return office;
	}

	//adding the Office
	@Override
	public Office createOffice(Office office) {
		Office result = officeRepository.save(office);
		return result;
	}

	//delete the Office
	@Override
	public void deleteOffice(Long officeId) {
		officeRepository.deleteById(officeId);
		
	}

	//update the Office
	@Override
	public void updateOffice(Office office, Long officeId) {
		// TODO Auto-generated method stub
		
	}
	
	//get Offices using paging
		@Override
		public List<Office> getOfficesUsingPaging() {
			Pageable pageable = PageRequest.of(0, 1);
			List<Office> list = officeRepository.findOffices(pageable);
			return list;
		}
	
}
