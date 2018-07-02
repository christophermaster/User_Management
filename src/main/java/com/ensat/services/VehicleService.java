package com.ensat.services;

import com.ensat.entities.VehicleEntity;

public interface VehicleService {
	
	Iterable<VehicleEntity> listAllVehicle();
	
	VehicleEntity  getVehicleById(Integer id);
	
	VehicleEntity saveVehicle(VehicleEntity vehicle);
	
	void deleteVehicle(Integer id);
	

}
