

package com.ecrops.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.VillageSec;
import com.ecrops.projection.ActiveSeasonProjection;

public interface VillageRevRepo extends JpaRepository<VillageSec, Integer> {

	//villages list based on village secretariate/rbk 

	@Query(value = "select dcode,mcode,wbdcode,wbmcode,vscode,vcode,wbdname,wbmname,wbvname from uds.villsec_rev_v where vscode=:vscode", nativeQuery = true)
	public List<ActiveSeasonProjection> getVillageListByRbk(@Param("vscode") Integer vscode);
	
	@Query(value = "select distinct vscode, vsname from uds.villsec_rev_v where dcode = :dcode and mcode = :mcode order by vsname", nativeQuery = true)
	public List<ActiveSeasonProjection> getRbkListByMand(@Param("dcode") int dcode, @Param("mcode") int mcode);
}
