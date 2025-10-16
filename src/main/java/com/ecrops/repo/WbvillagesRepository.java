package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.WbVillageMastEntity;
import com.ecrops.projection.WbVillageMastProjection;

public interface WbvillagesRepository extends JpaRepository<WbVillageMastEntity, Integer> {
	
	@Query(value="select wbdcode, wbmcode from uds.wbvillage_mst where dcode=:district and mcode=:mandal",nativeQuery=true)
	public List<WbVillageMastProjection> getWebLandDetails(@Param("district") Integer district, @Param("mandal") Integer mandal);


	@Query(value="select wbvcode, wbvname from uds.wbvillage_mst where wbvcode in(select vcode from uds.villsec_rev_v where vscode=:rbkcode)",nativeQuery=true)
	public List<WbVillageMastProjection> getWebLandDet(@Param("rbkcode") Integer rbkCode);
	
//	@Query(value="select wbvcode, wbvname from uds.wbvillage_mst where mcode=:mcode and ecrop_dwn='Y' and wbvcode not in (select vcode from u.downloaddetails where cropyear=:cropyear and season=:season)",nativeQuery=true)
//	public List<WbVillageMastProjection> getVillageData(@Param("mcode") Integer mcode,@Param("cropyear") Integer cropyear,@Param("season") String season);
  
	WbVillageMastEntity findByWbvcode(Integer vcode);
	
	@Query(value = "select wbdcode,wbedname,wbmcode,wbemname,sum(nonsubsidyamt) as nonsubsidyamt from farmmechanization.appl_details_v "
			+ "where wbdcode=? group by wbdcode,wbedname,wbmcode,wbemname order by wbedname,wbemname", nativeQuery = true)
	public List<AbsNonSub> getAbsNonSubsidy(@Param("wbdcode") Integer wbdcode);

	interface AbsNonSub {
		String getWbedname();
		String getWbemname();
		String getNonsubsidyamt();
	}
	
	@Query(value = "select wbdcode,wbmcode,wbvcode,wbedname,wbemname,wbevname,sum(nonsubsidyamt) as nonsubsidyamt from "
			+ "farmmechanization.appl_details_v where wbdcode=? and wbmcode=? group by\r\n"
			+ "wbdcode,wbmcode,wbvcode,wbedname,wbemname,wbevname order by wbemname,wbevname", nativeQuery = true)
	public List<VillAbsNonSub> getVillAbsNonSubsidy(@Param("wbdcode") Integer wbdcode,@Param("wbmcode") Integer wbmcode);

	interface VillAbsNonSub {
		String getWbedname();
		String getWbemname();
		String getWbevname();
		String getNonsubsidyamt();
	}
}
