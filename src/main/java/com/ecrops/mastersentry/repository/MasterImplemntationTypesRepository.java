package com.ecrops.mastersentry.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecrops.masters.MastersImplementation;

@Repository
public interface MasterImplemntationTypesRepository  extends JpaRepository<MastersImplementation, Integer> {

	
	
	 @Transactional
	    @Modifying
    @Query(value = "UPDATE farmmechanization.mast_implement_types SET status = 'Y' WHERE impltype_id = :id", nativeQuery = true)
	void deActiate(@Param("id") int  id);

	
    List<MastersImplementation> findByStatus(char status);
    
    
    
    @Query(value="  select status from farmmechanization.mast_implements  where  impl_type=? ",nativeQuery = true)
    List<String> findStatusByImplId(int impid);



}
