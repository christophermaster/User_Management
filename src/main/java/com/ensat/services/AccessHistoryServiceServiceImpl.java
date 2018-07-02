package com.ensat.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.AccessHistoryEntity;
import com.ensat.repositories.AccessHistoryRepository;

@Service
public class AccessHistoryServiceServiceImpl  implements AccessHistoryService{

	private AccessHistoryRepository accessHistoryRepository;
	
	@Autowired
	public void setComunityRepository(AccessHistoryRepository accessHistoryRepository) {
		this.accessHistoryRepository = accessHistoryRepository;
	}

	@Override
	public Iterable<AccessHistoryEntity> listAllAccessHistory() {

		return accessHistoryRepository.findAll();
	}

	@Override
	public AccessHistoryEntity getAccessHistoryById(Integer id) {

		return accessHistoryRepository.findOne(id);
	}

	@Override
	public AccessHistoryEntity saveAccessHistory(AccessHistoryEntity accessHistory) {
	
		return accessHistoryRepository.save(accessHistory);
	}

	@Override
	public void deleteAccessHistory(Integer id) {
		accessHistoryRepository.delete(id);
		
	}
	
	

}
