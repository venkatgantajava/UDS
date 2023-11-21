package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.Cultivator;

@Repository
public interface CultivatorRepository extends JpaRepository<Cultivator, Integer> {

	// String cr_booking = null;

	@Query(value = "SELECT * , (tot_extent-occupant_extent) available_extent  FROM cr_booking WHERE kh_no =:kh_No", nativeQuery = true)
	List<Cultivator> getCultivatorDetailsByKathaNo(@Param("kh_No") Integer khNo);

}
