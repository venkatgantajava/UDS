package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.UserRegEntity;

@Repository

public interface UserRegRepo extends JpaRepository<UserRegEntity, String> {

	@Query(value = "SELECT *  from user_registration  WHERE Userid=:userId and status='A'", nativeQuery = true)

	List<UserRegEntity> getUserDetails(@Param("userId") String userId);

	@Query(value = "select userid,encpassword, type_user from user_registration where userid=:userId", nativeQuery = true)

	public List<Object[]> find(@Param("userId") String userId);

	@Query(value = "select type_user from user_registration where userid = :userid", nativeQuery = true)
	public String getUserType(@Param("userid") String userid);

	@Query(value = "select wb.wbedname, wb.wbemname, wb.wbvname, wb.wbdcode, wb.wbmcode, wb.wbvcode, ur.*, ut.name typename, ut.usertype  from user_registration ur, usertypes ut, wbvillage_mst wb where wb.wbvcode = ur.wbvcode and ur.type_user = ut.type_user and ur.userid = :userId", nativeQuery = true)

	public UserRegEntity getSessionValuesWithVcode(@Param("userId") String userId);

	@Query(value = "select wb.wbedname, wb.wbemname, wb.wbvname, wb.wbdcode, wb.wbmcode, wb.wbvcode, ur.*, ut.name typename, ut.usertype from user_registration ur, usertypes ut, wbvillage_mst wb where wb.wbdcode = ur.wbdcode and wb.wbmcode = ur.wbmcode and ur.type_user = ut.type_user and ur.userid = :userId limit 1", nativeQuery = true)

	public UserRegEntity getSessionValuesWithoutVcode(@Param("userId") String userId);

}