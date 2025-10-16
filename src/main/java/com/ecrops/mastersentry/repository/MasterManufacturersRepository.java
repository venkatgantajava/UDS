package com.ecrops.mastersentry.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.masters.MasterManufacturers;

public interface MasterManufacturersRepository  extends JpaRepository<MasterManufacturers, Integer> {
	
	
	
	
	List<MasterManufacturers> findByStatus(char status);
	
	
	@Transactional
    @Modifying
    @Query(value = "UPDATE farmmechanization.mast_manufacturers SET status = 'Y' WHERE mnf_id = :id", nativeQuery = true)
	void setStaus(@Param("id") int id);

	
}
