package com.ensat.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.OwnerEntity;
import com.ensat.repositories.OwnerRepository;

@Service
public class OwnerServiceImpl  implements OwnerService{

	private OwnerRepository ownerRepository;
	
	@Autowired
	public void setOwnerRepository(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}
	
	
	@Override
	public Iterable<OwnerEntity> listAllOwner() {
		// TODO Auto-generated method stub
		return ownerRepository.findAll();
	}

	@Override
	public OwnerEntity getOwnerById(Integer id) {
		// TODO Auto-generated method stub
		return ownerRepository.findOne(id);
	}

	@Override
	public OwnerEntity saveOwner(OwnerEntity comunyty) {
		// TODO Auto-generated method stub
		return ownerRepository.save(comunyty);
	}

	@Override
	public void deleteOwner(Integer id) {
		// TODO Auto-generated method stub
		ownerRepository.delete(id);
	}



	
	

}
