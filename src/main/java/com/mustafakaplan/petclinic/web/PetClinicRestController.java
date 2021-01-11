package com.mustafakaplan.petclinic.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mustafakaplan.petclinic.exception.OwnerNotFoundException;
import com.mustafakaplan.petclinic.model.Owner;
import com.mustafakaplan.petclinic.service.PetClinicService;

@RestController
@RequestMapping("/rest")
public class PetClinicRestController {

	@Autowired 
	PetClinicService petClinicService;
	
	@RequestMapping(method=RequestMethod.GET, value = "/owners")
	public ResponseEntity<List<Owner>> getOwners() {
		
		List<Owner> owners = petClinicService.findOwners();
		return ResponseEntity.ok(owners);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/owner")
	public ResponseEntity<List<Owner>> getOwner(@RequestParam("ln") String lastName) {
		
		List<Owner> owners = petClinicService.findOwners(lastName);
		return ResponseEntity.ok(owners);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/owner/{id}")
	public ResponseEntity<Owner> getOwner(@PathVariable("id") Long id) {
		
		try {
			Owner owner = petClinicService.findOwner(id);
			return ResponseEntity.ok(owner);
		} catch (OwnerNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}	
}
