package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.Village;
import com.ecrops.projection.ActiveSeasonProjection;

public interface VillSecRepo extends JpaRepository<Village, Integer> {
	

//	@Query(value = "select vcode, wbvname from ecrop2024.villsec_rev_v where vscode=:vcode", nativeQuery = true)
//	public List<ActiveSeasonProjection> getRbk(@Param("vcode") int vcode);
//	
//	@Query(value = "select distinct vcode,vname from vill_sec_det where vcode in (select rbkcode from ecrop2024.emp_rbk_map where mcode=5066) order by vname", nativeQuery = true)
//	public List<ActiveSeasonProjection> getRbk();


	@Query(value = "select distinct vcode,vname from uds.vill_sec_det where  mcode=:mandalcode order by vcode", nativeQuery = true)
	public List<ActiveSeasonProjection> getVname(@Param("mandalcode") Integer mandalcode);
//
////AJAXIMEI
//	@Query(value="select imei1 from devicedet where  vcode=:villagecode",nativeQuery = true)
//	public List<ActiveSeasonProjection> getVcode(@Param("villagecode") Integer villagecode);
	
	
}


