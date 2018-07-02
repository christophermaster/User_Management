package com.ensat.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.ComunityEntity;
import com.ensat.repositories.ComunityRepository;

@Service
public class ComunityServiceImpl  implements ComunityService{

	private ComunityRepository comunityRepository;
	
	@Autowired
	public void setComunityRepository(ComunityRepository comunityRepository) {
		this.comunityRepository = comunityRepository;
	}
	
	
	@Override
	public Iterable<ComunityEntity> listAllComunyty() {
		// TODO Auto-generated method stub
		return comunityRepository.findAll();
	}

	@Override
	public ComunityEntity getComunityById(Integer id) {
		// TODO Auto-generated method stub
		return comunityRepository.findOne(id);
	}

	@Override
	public ComunityEntity saveComunity(ComunityEntity comunyty) {
		// TODO Auto-generated method stub
		return comunityRepository.save(comunyty);
	}

	@Override
	public void deleteComunity(Integer id) {
		// TODO Auto-generated method stub
		comunityRepository.delete(id);
	}


	
	

}
