package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.RbkEntity;
import com.ecrops.projection.InchargeRbkProjection;
import com.ecrops.projection.RbkDetailsProjection;

public interface InchargeRbkRepo extends JpaRepository<RbkEntity, String> {
	
	@Query(value = "Select incharge_sts from ecrop2023.emp_rbk_map where rbkcode=:rbkCode", nativeQuery = true)
	public List<InchargeRbkProjection> getInchargeStatus(@Param("rbkCode") Integer rbkCode);
	

	@Query(value = "Select dcode, mcode, vcode, rbkcode, empcode, ts, rbkuserid, ipaddress, wbdcode, wbmcode, incharge_sts from ecrop2023.emp_rbk_map where rbkcode=:rbkCode", nativeQuery = true)
	public List<InchargeRbkProjection> getRbkDetailsToSave(@Param("rbkCode") Integer rbkCode);
	
	@Query(value = "update  ecrop2023.emp_rbk_map set incharge_sts=:incStatus, empcode=:empCode where rbkcode=:rbkCode", nativeQuery = true)
	public List<RbkDetailsProjection> updateInchargeStatus(@Param("incStatus") String incStatus, @Param("empCode") Integer empCode,@Param("rbkCode") Integer rbkCode);
	
	@Query(value="select c.vname, a.emp_code,emp_name,rbkuserid,mobile,email,'xxxxxxxx'||right(aadhaar_id,4) as aadhaar_id,incharge_sts from ecrop2023.cr_emp_profile a ,\r\n"
			+ "ecrop2023.emp_rbk_map b,vill_sec_det c where  a.dcode=b.dcode and a.mcode=b.mcode and b.dcode=c.dcode and b.mcode=c.mcode and \r\n"
			+ "b.rbkcode=c.vcode and b.incharge_sts='R' and a.emp_code=b.empcode and a.dcode=:distcode and a.mcode=:mandalcode order by vname",nativeQuery = true)
	public List<RbkDetailsProjection> getRegDMcode(@Param("distcode") Integer distCode,@Param("mandalcode") Integer mandalcode);

}
