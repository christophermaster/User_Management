package com.ensat.services;

import com.ensat.entities.OwnerEntity;

public interface OwnerService {
	
	Iterable<OwnerEntity> listAllOwner();
	
	OwnerEntity  getOwnerById(Integer id);
	
	OwnerEntity saveOwner(OwnerEntity owner);
	
	void deleteOwner(Integer id);
	

}
