package com.ensat.services;


import com.ensat.entities.AccessHistoryEntity;

public interface AccessHistoryService {
	
	Iterable<AccessHistoryEntity> listAllAccessHistory();
	
	AccessHistoryEntity  getAccessHistoryById(Integer id);
	
	AccessHistoryEntity saveAccessHistory(AccessHistoryEntity accessHistory);
	
	void deleteAccessHistory(Integer id);

	

}
