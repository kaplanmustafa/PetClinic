package com.mustafakaplan.petclinic.dao.mem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.mustafakaplan.petclinic.dao.OwnerRepository;
import com.mustafakaplan.petclinic.model.Owner;

@Repository
public class OwnerRepositoryInMemoryImpl implements OwnerRepository {

	private Map<Long, Owner> ownersMap = new HashMap<>();
	
	public OwnerRepositoryInMemoryImpl() {
		
		for(int i=0; i<10; i++) {
			Owner owner = new Owner();
			owner.setId((long) (i+1));
			owner.setFirstName("Ad" + (i+1));
			owner.setLastName("Soyad" + (i+1));
			
			ownersMap.put(owner.getId(), owner);
		}
	}

	@Override
	public List<Owner> findAll() {
		
		return new ArrayList<>(ownersMap.values());
	}

	@Override
	public Owner findById(Long id) {
		
		return ownersMap.get(id);
	}

	@Override
	public List<Owner> findByLastName(String lastName) {
		
		return ownersMap.values().stream().filter(item -> item.getLastName().equals(lastName)).collect(Collectors.toList());
	}

	@Override
	public void create(Owner owner) {
		
		owner.setId(new Date().getTime());
		ownersMap.put(owner.getId(), owner);
	}

	@Override
	public Owner update(Owner owner) {

		ownersMap.replace(owner.getId(), owner);
		return owner;
	}

	@Override
	public void delete(Long id) {

		ownersMap.remove(id);
	}
}
