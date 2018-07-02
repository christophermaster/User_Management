package com.ensat.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.OwnershipEntity;
import com.ensat.entities.VehicleEntity;
import com.ensat.repositories.OwnershipRepository;
import com.ensat.repositories.VehicleRepository;


@Service
public class VehicleServiceImpl  implements VehicleService{
	
	private VehicleRepository vehicleRepository;
	
	@Autowired 
	public void setOwnershipRepository(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	public Iterable<VehicleEntity> listAllVehicle() {
		// TODO Auto-generated method stub
		return vehicleRepository.findAll();
	}

	@Override
	public VehicleEntity getVehicleById(Integer id) {
		// TODO Auto-generated method stub
		return vehicleRepository.findOne(id);
	}

	@Override
	public VehicleEntity saveVehicle(VehicleEntity vehicle) {
		// TODO Auto-generated method stub
		return vehicleRepository.save(vehicle);
	}

	@Override
	public void deleteVehicle(Integer id) {
		vehicleRepository.delete(id);
		
	}

	
	

}
