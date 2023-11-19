package com.ecrops.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface WbMasterRepo {
	

	@Query(value="SELECT DISTINCT wbedname, wbemname, user_registration.userid AS uid FROM user_registration INNER JOIN wbvillage_mst ON wbvillage_mst.wbdcode = user_registration.wbdcode AND wbvillage_mst.wbmcode = user_registration.wbmcode WHERE wbvillage_mst.wbdcode = :wbedname AND wbvillage_mst.wbmcode = :wbemname AND user_registration.userid = :userId", nativeQuery = true)
	public List<Map<String, Object>> getSessionValues(@Param("userId") String uid);

}
	
		//List<WbDetails> getVillages(@Param("wbedname") int wbedname,@Param("wbemname") int wbemname,@Param("userId") String userid);



//@Query(value ="SELECT ur.name, ur.village, ur.userid, ur.wbdcode, ur.wbmcode AS lgddname, lgdmname, ur.district AS distcode, ur.blockortehsil AS mandcode, wb.wbedname, wb.wbemname\r\n"
//		+ "FROM user_registration ur\r\n"
//		+ "JOIN wbvillage_mst wb ON ur.wbdcode = wb.wbdcode AND ur.wbmcode = wb.wbmcode\r\n"
//		+ "WHERE ur.userid = :userId")




//@Query(value="select distinct wbedname,wbemname,user_registration.userid as uid from user_registration inner join wbvillage_mst"
//	+ " on wbvillage_mst.wbdcode=:wbedname and wbvillage_mst.wbmcode=:wbemname and user_registration.userid=':userId' where "
//	+ " wbvillage_mst.wbdcode=user_registration.wbdcode and wbvillage_mst.wbmcode=user_registration.wbmcode", nativeQuery = true)
//public List<Map<String, Object>> getSessionValues(@Param("userId") String uid);
//
//}
