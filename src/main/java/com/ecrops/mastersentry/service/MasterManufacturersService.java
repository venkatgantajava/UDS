package com.ecrops.mastersentry.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.masters.MasterManufacturers;
import com.ecrops.mastersentry.repository.MasterManufacturersRepository;

@Service
public class MasterManufacturersService {
	
	@Autowired
	MasterManufacturersRepository  manufacturersRepository;
	
	
	
	public List<MasterManufacturers>  getAllData(){
		
		
		return manufacturersRepository.findAll();
		
	}



	public MasterManufacturers addMasterManufacturers(MasterManufacturers manufacturers) {
		
		MasterManufacturers  masterManufacturers=new MasterManufacturers();
	//	masterManufacturers.setMid(manufacturers.getMid());
		
		masterManufacturers.setImpid(manufacturers.getImpid());
		
		masterManufacturers.setMname(manufacturers.getMname());
		
		
		masterManufacturers.setStatus('A');
		masterManufacturers.setDatecrt(LocalDateTime.now());
		masterManufacturers.setDateupdt(LocalDateTime.now());

		manufacturersRepository.save(masterManufacturers);
		
		
		return masterManufacturers;
		// TODO Auto-generated method stub
		
	}



	public void deleteById(int id) {
		// TODO Auto-generated method stub
		manufacturersRepository.deleteById(id);
		
	}



	public MasterManufacturers getSaveDeatails(MasterManufacturers manufacturers, int  visitIdperOptional) {
		// TODO Auto-generated method stub
		
		MasterManufacturers  masterManufacturers=new MasterManufacturers();
			masterManufacturers.setMid(visitIdperOptional);
			masterManufacturers.setImpid(manufacturers.getImpid());
			
			masterManufacturers.setMname(manufacturers.getMname());
			
			
			masterManufacturers.setStatus('A');
			masterManufacturers.setDatecrt(LocalDateTime.now());
			masterManufacturers.setDateupdt(LocalDateTime.now());

			manufacturersRepository.save(masterManufacturers);
			
			
			return masterManufacturers;
		
		
		
	}

}
