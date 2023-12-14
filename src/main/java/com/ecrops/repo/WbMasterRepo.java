package com.ecrops.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WbMasterRepo {

	@Query(value = "SELECT DISTINCT wbedname, wbemname, user_registration.userid AS uid FROM user_registration INNER JOIN wbvillage_mst ON wbvillage_mst.wbdcode = user_registration.wbdcode AND wbvillage_mst.wbmcode = user_registration.wbmcode WHERE wbvillage_mst.wbdcode = :wbedname AND wbvillage_mst.wbmcode = :wbemname AND user_registration.userid = :userId", nativeQuery = true)
	public List<Map<String, Object>> getSessionValues(@Param("userId") String uid);
	
	

}
