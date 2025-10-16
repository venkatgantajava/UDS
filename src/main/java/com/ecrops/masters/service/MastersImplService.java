package com.ecrops.masters.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.masters.MastersImplementation;
import com.ecrops.mastersentry.repository.MasterImplemntationTypesRepository;



@Service
public class MastersImplService {

	@Autowired
	private MasterImplemntationTypesRepository masterImplemntationTypesRepository;
	
	
	
	public  MastersImplementation getmasterData(String data) {
		
		MastersImplementation mastersImplementationTypes=new MastersImplementation();
		
		mastersImplementationTypes.setImplementname(data);		
		mastersImplementationTypes.setDatecrt(LocalDateTime.now());
		mastersImplementationTypes.setDateupdt(LocalDateTime.now());
		mastersImplementationTypes.setStatus('A');
		
		masterImplemntationTypesRepository.save(mastersImplementationTypes);
		
		return mastersImplementationTypes;
		
		
		
		
	}
	
	  public    List<MastersImplementation> getAllData(){
		  List<MastersImplementation>  listdata= masterImplemntationTypesRepository.findByStatus('A');
		  
		return listdata;
	    	
	    }


	  public void deleteByIdData(int id) {
		  masterImplemntationTypesRepository.deleteById(id);
	    }
	
	
	  public  MastersImplementation getEditData(int id,String name) {

			MastersImplementation mastersImplementationTypes=new MastersImplementation();
			mastersImplementationTypes.setImplementid(id);
			mastersImplementationTypes.setImplementname(name);	
			mastersImplementationTypes.setDatecrt(LocalDateTime.now());
			mastersImplementationTypes.setDateupdt(LocalDateTime.now());
			mastersImplementationTypes.setStatus('A');
			
			
			masterImplemntationTypesRepository.save(mastersImplementationTypes);
			
			return mastersImplementationTypes;
			
			
			
			
		}

	public void deActiate(int id) {
		// TODO Auto-generated method stub
		masterImplemntationTypesRepository.deActiate(id);
	}
	  
	  
	  public List<String>  getStatusData(int implid){
	return   masterImplemntationTypesRepository.findStatusByImplId(implid);
	 
	  }
	  
}
