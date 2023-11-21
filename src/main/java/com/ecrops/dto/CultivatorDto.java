package com.ecrops.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cr_booking")
public class CultivatorDto {

	@EmbeddedId
	CultivatorEmbedableDto cultivatorEmbedableDto;

	@Column(name = "cr_sno")
	private String crSno;

	@Column(name = "tot_extent")
	private Double totalExtent;

	@Column(name = "cr_farmeruid")
	private Long aadharNo;

	@Column(name = "oc_fname")
	private String fatherName;

	@Column(name = "occupant_extent")
	private Double occupantExtent;

	@Column(name = "kh_no")
	private Integer khNo;

	@Column(name = "oc_name")
	private String ocName;

	@Column(name = "cr_vcode")
	private Integer cr_vcode;

	@Column(name = "cr_year")
	private Integer cr_year;

	@Column(name = "cr_season")
	private String cr_season;

	@Column(name = "owner_tenant")
	private String owner_tenant;

	public CultivatorEmbedableDto getCultivatorEmbedableDto() {
		return cultivatorEmbedableDto;
	}

	public void setCultivatorEmbedableDto(CultivatorEmbedableDto cultivatorEmbedableDto) {
		this.cultivatorEmbedableDto = cultivatorEmbedableDto;
	}

	public String getCrSno() {
		return crSno;
	}

	public void setCrSno(String crSno) {
		this.crSno = crSno;
	}

	public Double getTotalExtent() {
		return totalExtent;
	}

	public void setTotalExtent(Double totalExtent) {
		this.totalExtent = totalExtent;
	}

	public Long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Double getOccupantExtent() {
		return occupantExtent;
	}

	public void setOccupantExtent(Double occupantExtent) {
		this.occupantExtent = occupantExtent;
	}

	public Integer getKhNo() {
		return khNo;
	}

	public void setKhNo(Integer khNo) {
		this.khNo = khNo;
	}

	public String getOcName() {
		return ocName;
	}

	public void setOcName(String ocName) {
		this.ocName = ocName;
	}

	public Integer getCr_vcode() {
		return cr_vcode;
	}

	public void setCr_vcode(Integer cr_vcode) {
		this.cr_vcode = cr_vcode;
	}

	public Integer getCr_year() {
		return cr_year;
	}

	public void setCr_year(Integer cr_year) {
		this.cr_year = cr_year;
	}

	public String getCr_season() {
		return cr_season;
	}

	public void setCr_season(String cr_season) {
		this.cr_season = cr_season;
	}

	public String getOwner_tenant() {
		return owner_tenant;
	}

	public void setOwner_tenant(String owner_tenant) {
		this.owner_tenant = owner_tenant;
	}

	public CultivatorDto(CultivatorEmbedableDto cultivatorEmbedableDto, String crSno, Double totalExtent, Long aadharNo,
			String fatherName, Double occupantExtent, Integer khNo, String ocName, Integer cr_vcode, Integer cr_year,
			String cr_season, String owner_tenant) {
		super();
		this.cultivatorEmbedableDto = cultivatorEmbedableDto;
		this.crSno = crSno;
		this.totalExtent = totalExtent;
		this.aadharNo = aadharNo;
		this.fatherName = fatherName;
		this.occupantExtent = occupantExtent;
		this.khNo = khNo;
		this.ocName = ocName;
		this.cr_vcode = cr_vcode;
		this.cr_year = cr_year;
		this.cr_season = cr_season;
		this.owner_tenant = owner_tenant;
	}

	public CultivatorDto(CultivatorEmbedableDto cultivatorEmbedableDto, Long aadharNo, Double totalExtent) {
		super();
		this.cultivatorEmbedableDto = cultivatorEmbedableDto;
		this.totalExtent = totalExtent;
		this.aadharNo = aadharNo;
	}

	public CultivatorDto() {
		super();
	}

}
