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

	@Query(value = "SELECT SUM(tot_extent) tot_extent FROM CR_BOOKING WHERE kh_no = :khNo and cr_farmeruid = :cr_farmeruid AND owner_tenant = :owner_tenant GROUP BY kh_no, cr_farmeruid", nativeQuery = true)
	List<Cultivator> getCultivatorDetailsByKathaNo(@Param("khNo") Integer khNo,
			@Param("owner_tenant") String owner_tenant, @Param("cr_farmeruid") String cr_farmeruid);

}
