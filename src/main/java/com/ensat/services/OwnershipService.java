package com.ensat.services;

import com.ensat.entities.OwnershipEntity;

public interface OwnershipService {
	
	Iterable<OwnershipEntity> listAllOwner();
	
	OwnershipEntity  getOwnerById(Integer id);
	
	OwnershipEntity saveOwner(OwnershipEntity owner);
	
	void deleteOwner(Integer id);
	

}
