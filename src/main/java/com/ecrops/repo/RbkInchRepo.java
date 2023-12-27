package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.RbkInchEntity;
import com.ecrops.projection.InchargeRbkProjection;

public interface RbkInchRepo extends JpaRepository<RbkInchEntity, Integer> {
	
	@Query(value="select aadhaar_id,mobile,emp_name,vsdname,vsmname,vname,a.rbkcode,empcode,rbkuserid,"
			+ "inchargests from ecrop2023.emp_rbk_map_incharges a,vill_sec_det c,"
			+ "ecrop2023.cr_emp_profile b where a.dcode=c.dcode  and a.mcode=c.mcode and a.rbkcode=c.vcode\r\n"
			+ "and a.empcode=b.emp_code and a.dcode=:distcode and a.mcode=:mandalcode order by vname",nativeQuery=true)
	public List<InchargeRbkProjection> getDMcode(@Param("distcode") Integer distCode,@Param("mandalcode") Integer mandalcode);

}
