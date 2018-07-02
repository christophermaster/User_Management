package com.ensat.services;




import com.ensat.entities.ComunityEntity;


public interface ComunityService {
	
	Iterable<ComunityEntity> listAllComunyty();
	
	ComunityEntity  getComunityById(Integer id);
	
	ComunityEntity saveComunity(ComunityEntity comunyty);
	
	void deleteComunity(Integer id);

	

}
