package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.VillageForHO;

@Repository
public interface VillageRepositoryFhorestpwd extends JpaRepository<VillageForHO, Integer> {

	
	@Query(value = "select distinct vscode,vsname from uds.villsec_rev_v where vscode=? order by vsname", nativeQuery = true)
	List<VillageForHO> getRbk(@Param("vscode") Integer vscode);
	
	
	@Query(value = "select distinct vcode as vscode,wbvname as vsname from uds.villsec_rev_v where mcode=? order by wbvname", nativeQuery = true)
	List<VillageForHO> getVro(@Param("mcode") Integer mcode);

}
