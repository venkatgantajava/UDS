package com.ecrops.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.District;
import com.ecrops.projection.DistrictProjections;

@Repository
@Component
public interface DistrictRepository extends JpaRepository<District, Integer>{
	@Query(value = "SELECT wbdcode,dname FROM farmmechanization.district_2011_cs  where wbdcode<>88 group by wbdcode,dname  order by dname ",nativeQuery=true)
	List<DistrictProjections> getDistrictList();
	
	@Query(value = "SELECT distinct wbdcode,dname FROM uds.district_2011_cs  where wbdcode<>88 and wbdcode not in (select distinct wbdcode from farmmechanization.target_dist_t) order by dname ",nativeQuery=true)
	List<DistrictProjections> getDistrictListForTarget();
	
	@Query(value = "SELECT distinct wbmcode,wbemname FROM uds.wbvillage_mst where wbdcode=:wbdcode   order by wbemname ",nativeQuery=true)
	List<DistrictProjections> getMandalList(@Param("wbdcode")int wbdcode);
	
	@Query(value = "SELECT distinct wbmcode,wbemname FROM farmmechanization.getlist_dispatchdetentry_v where wbdcode=:wbdcode and manufacture_id=:manfId order by wbemname ",nativeQuery=true)
	List<DistrictProjections> getMandalListForDispatch(@Param("wbdcode")int wbdcode,@Param("manfId") Integer manfId);
	
	@Query(value = "SELECT distinct vscode,vsname FROM uds.villsec_rev_v where wbdcode=:wbdcode and wbmcode=:wbmcode   order by vsname ",nativeQuery=true)
	
	List<DistrictProjections> getRskList(@Param("wbdcode")int wbdcode,@Param("wbmcode")int wbmcode);
	@Query(value = "SELECT distinct rbkcode as vscode,rbkname as vsname FROM farmmechanization.getlist_dispatchdetentry_v where wbdcode=:wbdcode and wbmcode=:wbmcode   order by rbkname ",nativeQuery=true)
	List<DistrictProjections> getRskListForDispatch(@Param("wbdcode")int wbdcode,@Param("wbmcode")int wbmcode);

}