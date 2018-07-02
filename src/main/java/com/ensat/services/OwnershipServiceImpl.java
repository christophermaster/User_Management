package com.ensat.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.OwnershipEntity;
import com.ensat.repositories.OwnershipRepository;


@Service
public class OwnershipServiceImpl  implements OwnershipService{
	
	private OwnershipRepository ownershipRepository;
	
	@Autowired 
	public void setOwnershipRepository(OwnershipRepository ownershipRepository) {
		this.ownershipRepository = ownershipRepository;
	}

	@Override
	public Iterable<OwnershipEntity> listAllOwner() {
		// TODO Auto-generated method stub
		return ownershipRepository.findAll();
	}

	@Override
	public OwnershipEntity getOwnerById(Integer id) {
		// TODO Auto-generated method stub
		return ownershipRepository.findOne(id);
	}

	@Override
	public OwnershipEntity saveOwner(OwnershipEntity owner) {
		// TODO Auto-generated method stub
		return ownershipRepository.save(owner);
	}

	@Override
	public void deleteOwner(Integer id) {
		// TODO Auto-generated method stub
		ownershipRepository.delete(id);
	}

	
	



	
	

}
