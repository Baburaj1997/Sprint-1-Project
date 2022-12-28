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

//import com.shoppingcart.project.app.Repository.OfficeRepository;
import com.shoppingcart.project.app.exception.OfficeNotFoundException;
import com.shoppingcart.project.app.model.Office;
import com.shoppingcart.project.app.service.OfficeService;



@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/offices/")
public class OfficeController {
	
	@Autowired
	private OfficeService officeService;

	/*------------------------------------------------------------------------------
 	GET 	 findAll method
	--------------------------------------------------------------------------------
	 */
		//Find all office
	@GetMapping("offices")
	public ResponseEntity<List<Office>> getAllOffices() throws OfficeNotFoundException {
		List<Office> office = officeService.getAllOffices();
		
		if(office.size()<=0) {
			throw new OfficeNotFoundException("Office record is empty");
		}
		return ResponseEntity.of(Optional.of(office));
	}

	/*------------------------------------------------------------------------------
 	Post 	create method
	--------------------------------------------------------------------------------
	 */
		//Add office
	@PostMapping("offices")
	public ResponseEntity<Office> createOffice(@RequestBody Office office) throws OfficeNotFoundException {
		Office o = officeService.createOffice(office);
		
		if(o == null) {
			throw new OfficeNotFoundException("Office not get inserted");
		}
		return ResponseEntity.of(Optional.of(o));
		
	}

	/*------------------------------------------------------------------------------
 	GET 	 findByid method
	--------------------------------------------------------------------------------
	 */
		//Find by Id
	@GetMapping("offices/{id}")
	public ResponseEntity<Office> getoffice(@PathVariable("id") Long id) throws OfficeNotFoundException  {
		Office office = officeService.getOfficeById(id)
				 .orElseThrow(() -> new OfficeNotFoundException("Office not exist with id:" + id));
		
		if(office == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(office));
	}
	
	
    /*------------------------------------------------------------------------------
 	PUT 	 update method
	--------------------------------------------------------------------------------
	 */

		//Update office
	    @PutMapping("offices/{officeId}")
		public ResponseEntity<Office> updateOffice(@RequestBody Office office, @PathVariable("officeId") Long officeId) throws OfficeNotFoundException {
			
			officeService.getOfficeById(officeId)
			 .orElseThrow(() -> new OfficeNotFoundException("Office not exist with id:" + officeId));
			
			officeService.updateOffice(office, officeId);
			return ResponseEntity.ok(office);
			
		}
	    
	/*------------------------------------------------------------------------------
 	DELETE
	--------------------------------------------------------------------------------
	 */
		//Delete office by id
		@DeleteMapping("offices/{officeId}")
		public ResponseEntity<Void> deleteOffice(@PathVariable("officeId") Long officeId) throws OfficeNotFoundException {
			
			officeService.getOfficeById(officeId)
				 .orElseThrow(() -> new OfficeNotFoundException("Office not exist with id:" + officeId));
			
			officeService.deleteOffice(officeId);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
	//------------------------------------------------------------------------------
	}
