package com.mustafakaplan.petclinic.service;

import java.util.List;

import com.mustafakaplan.petclinic.exception.OwnerNotFoundException;
import com.mustafakaplan.petclinic.model.Owner;

public interface PetClinicService {

	List<Owner> findOwners();
	
	List<Owner> findOwners(String lastName);
	
	Owner findOwner(Long id) throws OwnerNotFoundException;
	
	void createOwner(Owner owner);
	
	void updateOwner(Owner owner);
	
	void deleteOwner(Long id);
}
