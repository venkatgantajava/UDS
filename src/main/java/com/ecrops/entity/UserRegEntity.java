package com.ecrops.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_registration")
public class UserRegEntity {

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

	@Column(name = "encpassword")
	private String encpassword;

	@Column(name = "district")
	private Integer distCode;

	@Column(name = "blockortehsil")
	private Integer mandCode;

	@Column(name = "village")
	private Integer villCode;

	@Column(name = "wbmcode")
	private Integer wbMcode;

	@Column(name = "wbdcode")
	private String wbDcode;

	@Column(name = "wbvcode")
	private String wbvcode;

	@OneToOne
	@JoinColumn(name = "usertype", insertable = false, updatable = false)
	private UserTypesEntity userTypesEntity;

	@OneToOne
	@JoinColumn(name = "wbvcode", insertable = false, updatable = false)
	private WbMaster webMaster;

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

	public String getEncpassword() {
		return encpassword;
	}

	public void setEncpassword(String encpassword) {
		this.encpassword = encpassword;
	}

	public Integer getDistCode() {
		return distCode;
	}

	public void setDistCode(Integer distCode) {
		this.distCode = distCode;
	}

	public Integer getMandCode() {
		return mandCode;
	}

	public void setMandCode(Integer mandCode) {
		this.mandCode = mandCode;
	}

	public Integer getVillCode() {
		return villCode;
	}

	public void setVillCode(Integer villCode) {
		this.villCode = villCode;
	}

	public Integer getWbMcode() {
		return wbMcode;
	}

	public void setWbMcode(Integer wbMcode) {
		this.wbMcode = wbMcode;
	}

	public String getWbDcode() {
		return wbDcode;
	}

	public void setWbDcode(String wbDcode) {
		this.wbDcode = wbDcode;
	}

	public UserTypesEntity getUserTypesEntity() {
		return userTypesEntity;
	}

	public void setUserTypesEntity(UserTypesEntity userTypesEntity) {
		this.userTypesEntity = userTypesEntity;
	}

	public WbMaster getWebMaster() {
		return webMaster;
	}

	public void setWebMaster(WbMaster webMaster) {
		this.webMaster = webMaster;
	}

	public String getWbvcode() {
		return wbvcode;
	}

	public void setWbvcode(String wbvcode) {
		this.wbvcode = wbvcode;
	}

	public UserRegEntity(String name, String aadhaar_id, String type_user, String mobile_phone, String userid,
			String encpassword, Integer distCode, Integer mandCode, Integer villCode, Integer wbMcode, String wbDcode,
			String wbvcode, UserTypesEntity userTypesEntity, WbMaster webMaster) {
		super();
		this.name = name;
		this.aadhaar_id = aadhaar_id;
		this.type_user = type_user;
		this.mobile_phone = mobile_phone;
		this.userid = userid;
		this.encpassword = encpassword;
		this.distCode = distCode;
		this.mandCode = mandCode;
		this.villCode = villCode;
		this.wbMcode = wbMcode;
		this.wbDcode = wbDcode;
		this.wbvcode = wbvcode;
		this.userTypesEntity = userTypesEntity;
		this.webMaster = webMaster;
	}

	public UserRegEntity() {
		super();
	}

	@Override
	public String toString() {
		return "UserRegEntity [name=" + name + ", aadhaar_id=" + aadhaar_id + ", type_user=" + type_user
				+ ", mobile_phone=" + mobile_phone + ", userid=" + userid + ", encpassword=" + encpassword
				+ ", distCode=" + distCode + ", mandCode=" + mandCode + ", villCode=" + villCode + ", wbMcode="
				+ wbMcode + ", wbDcode=" + wbDcode + ", wbvcode=" + wbvcode + ", userTypesEntity=" + userTypesEntity
				+ ", webMaster=" + webMaster + "]";
	}

}