package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.Village;
import com.ecrops.projection.VillageName;

public interface VillRepo extends JpaRepository<Village, Integer>
{
	@Query(value="select vcode, vname from vill_sec_det where mcode=:mandal",nativeQuery=true)
	public List<VillageName> findVillName(@Param("mandal") Integer mandal);

	@Query(value="select vname from vill_sec_det where vcode=:villCode",nativeQuery=true)
	public List<VillageName> getVillName(@Param("villCode") Integer villCode);

}
