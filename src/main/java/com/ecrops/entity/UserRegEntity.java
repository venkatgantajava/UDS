package com.ecrops.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "user_registration",schema="public")
public class UserRegEntity {

	
	@Column(name = "usertype")
	public Integer userType;
	
	@Column(name = "name")
	private String name;

	@Column(name = "aadhaar_id")
	private String aadhaar_id;

	@Column(name = "type_user")
	private String type_user;

	@Column(name = "mobile_phone")
	private String mobile_phone;

	@Id
	@Column(name = "userid")
	private String userid;

	//@Column(name = "uds_encpassword")
	private String uds_encpassword;

	@Column(name = "district")
	private String district;

	@Column(name = "blockortehsil")
	private String blockortehsil;

	@Column(name = "village")
	private String village;

	@Column(name = "wbmcode")
	private Integer wbmcode;

	@Column(name = "wbdcode")
	private Integer wbdcode;
	
	@Email(message = "Email should be valid")
	@Column(name = "emailid")
	private String emailid;

	@Column(name = "wbvcode")
	private Integer wbvcode;
	
	@ManyToMany(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "userroles_v",schema="public",joinColumns = @JoinColumn(name = "userid"),
	inverseJoinColumns = @JoinColumn(name = "usertype"))
	Set<UserTypesEntity> roles = new HashSet<UserTypesEntity>();
	
	
	public UserRegEntity() {
		
	}


	public Integer getUserType() {
		return userType;
	}


	public void setUserType(Integer userType) {
		this.userType = userType;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAadhaar_id() {
		return aadhaar_id;
	}


	public void setAadhaar_id(String aadhaar_id) {
		this.aadhaar_id = aadhaar_id;
	}


	public String getType_user() {
		return type_user;
	}


	public void setType_user(String type_user) {
		this.type_user = type_user;
	}


	public String getMobile_phone() {
		return mobile_phone;
	}


	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUds_encpassword() {
		return uds_encpassword;
	}


	public void setUds_encpassword(String uds_encpassword) {
		this.uds_encpassword = uds_encpassword;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getBlockortehsil() {
		return blockortehsil;
	}


	public void setBlockortehsil(String blockortehsil) {
		this.blockortehsil = blockortehsil;
	}


	public String getVillage() {
		return village;
	}


	public void setVillage(String village) {
		this.village = village;
	}


	public Integer getWbmcode() {
		return wbmcode;
	}


	public void setWbmcode(Integer wbmcode) {
		this.wbmcode = wbmcode;
	}


	public Integer getWbdcode() {
		return wbdcode;
	}


	public void setWbdcode(Integer wbdcode) {
		this.wbdcode = wbdcode;
	}


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public Integer getWbvcode() {
		return wbvcode;
	}


	public void setWbvcode(Integer wbvcode) {
		this.wbvcode = wbvcode;
	}


	public Set<UserTypesEntity> getRoles() {
		return roles;
	}


	public void setRoles(Set<UserTypesEntity> roles) {
		this.roles = roles;
	}


	

	
	
}


