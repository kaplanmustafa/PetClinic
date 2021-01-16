package com.mustafakaplan.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mustafakaplan.petclinic.dao.OwnerRepository;
import com.mustafakaplan.petclinic.exception.OwnerNotFoundException;
import com.mustafakaplan.petclinic.model.Owner;

@Service
@Transactional(rollbackFor = Exception.class)
public class PetClinicServiceImpl implements PetClinicService {

	OwnerRepository ownerRepository;
	
	@Autowired
	public void setOwnerRepository(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Owner> findOwners() {
		
		return ownerRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Owner> findOwners(String lastName) {
		
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Owner findOwner(Long id) throws OwnerNotFoundException {

		Owner owner = ownerRepository.findById(id);
		
		if(owner == null) {
			throw new OwnerNotFoundException("Owner not found with id: " + id);
		}
		
		return owner;
	}

	@Override
	public void createOwner(Owner owner) {

		ownerRepository.create(owner);
	}

	@Override
	public void updateOwner(Owner owner) {

		ownerRepository.update(owner);
	}

	@Override
	public void deleteOwner(Long id) {

		ownerRepository.delete(id);
	}
}
