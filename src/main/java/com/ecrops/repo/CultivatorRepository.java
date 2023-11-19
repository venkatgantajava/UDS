package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.Cultivator;

@Repository
public interface CultivatorRepository  extends JpaRepository<Cultivator, Integer> {
	
	//String cr_booking = null;

	
	@Query(value = "SELECT * , (tot_extent-occupant_extent) available_extent  FROM cr_booking WHERE kh_no =:kh_No", nativeQuery = true)
	List<Cultivator> getCultivatorDetailsByKathaNo(@Param("kh_No") Integer khNo);
	
	
//	@Query(value = "SELECT * FROM cr_booking WHERE kh_no = :khNo", nativeQuery = true)
//	List<Cultivator> getCultivatorDetailsByKathaNo(@Param("khNo") int khNo);

}
	

	/*@Query(value=" SELECT cr_sno,bookingId,kh_no,oc_name,oc_fname,occupname,occupfname,anubhavadar_extent,cr_dist_code,cr_mand_code,"
			+ "cr_vcode,owner_tenant,tot_extent,occupant_extent,ctype,variety,cr_farmeruid,cr_year "
			+ "FROM cr_booking  WHERE kh_no=:kh_No ",nativeQuery = true)
	List<Cultivator> getCultivatorDetailsByKathaNo(@Param("kh_No") long khNo );
	
	} */

	
	