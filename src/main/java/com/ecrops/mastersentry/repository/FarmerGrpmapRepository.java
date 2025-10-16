package com.ecrops.mastersentry.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.masters.FarmerGrpmap;

public interface FarmerGrpmapRepository extends JpaRepository<FarmerGrpmap, Integer> {


	 @Modifying
	    @Transactional
	    @Query(value = "INSERT INTO farmmechanization.farmer_grp_map_t (cropyear, farmer_grp_type, farmer_id, grp_id, rskcode, vcode) " +
	                   "VALUES (:cropyear, :farmerGrpType, :farmerId, :grpId, :rskcode, :vcode)", nativeQuery = true)
	    void updateFarmerGroupMap(
	        @Param("cropyear") int cropyear,
	        @Param("farmerGrpType") char farmerGrpType,
	        @Param("farmerId") String farmerId,
	        @Param("grpId") String grpId,
	        @Param("rskcode") String rskcode,
	        @Param("vcode") int vcode
	    );
	
	
	 
	 @Modifying
	    @Transactional
	    @Query(value="update farmmechanization.mast_farmer_grp  set status='Y'  where grp_id =:grpid",nativeQuery = true)
	    void  updateMasterFarmerGroup(@Param("grpid")   int grpid);
	 
	 
	
	 
	 
	 @Modifying
	    @Transactional
	    @Query(value = " update farmmechanization.farmer_appl_det_t   set   grp_mapped ='A' where farmer_id=:farmerId  ", nativeQuery = true)
	    void updateGroupStatusInApplDet( @Param("farmerId") String farmerId );
	 
	 
	 
}
