package com.ecrops.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cr_booking")
public class Cultivator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingid")
	private Integer bookingId;

	@Column(name = "part_key")
	private String part_key;

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

	@Column(name = "refbookingid")
	private Integer refBookingId;

	@Column(name = "cultivator_type")
	private String cultivatorType;

	@Column(name = "anubhavadar_extent")
	private Double anubhavadarExtent;

	@Column(name = "cr_dist_code")
	private Integer crDistCode;

	@Column(name = "cr_mand_code")
	private Integer crMandCode;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getPart_key() {
		return part_key;
	}

	public void setPart_key(String part_key) {
		this.part_key = part_key;
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

	public Integer getRefBookingId() {
		return refBookingId;
	}

	public void setRefBookingId(Integer refBookingId) {
		this.refBookingId = refBookingId;
	}

	public String getCultivatorType() {
		return cultivatorType;
	}

	public void setCultivatorType(String cultivatorType) {
		this.cultivatorType = cultivatorType;
	}

	public Double getAnubhavadarExtent() {
		return anubhavadarExtent;
	}

	public void setAnubhavadarExtent(Double anubhavadarExtent) {
		this.anubhavadarExtent = anubhavadarExtent;
	}

	public Integer getCrDistCode() {
		return crDistCode;
	}

	public void setCrDistCode(Integer crDistCode) {
		this.crDistCode = crDistCode;
	}

	public Integer getCrMandCode() {
		return crMandCode;
	}

	public void setCrMandCode(Integer crMandCode) {
		this.crMandCode = crMandCode;
	}

	public Cultivator(Integer bookingId, String part_key, String crSno, Double totalExtent, Long aadharNo,
			String fatherName, Double occupantExtent, Integer khNo, String ocName, Integer cr_vcode, Integer cr_year,
			String cr_season, String owner_tenant, Integer refBookingId, String cultivatorType,
			Double anubhavadarExtent, Integer crDistCode, Integer crMandCode) {
		super();
		this.bookingId = bookingId;
		this.part_key = part_key;
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
		this.refBookingId = refBookingId;
		this.cultivatorType = cultivatorType;
		this.anubhavadarExtent = anubhavadarExtent;
		this.crDistCode = crDistCode;
		this.crMandCode = crMandCode;
	}

	public Cultivator() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cultivator [bookingId=" + bookingId + ", part_key=" + part_key + ", crSno=" + crSno + ", totalExtent="
				+ totalExtent + ", aadharNo=" + aadharNo + ", fatherName=" + fatherName + ", occupantExtent="
				+ occupantExtent + ", khNo=" + khNo + ", ocName=" + ocName + ", cr_vcode=" + cr_vcode + ", cr_year="
				+ cr_year + ", cr_season=" + cr_season + ", owner_tenant=" + owner_tenant + ", refBookingId="
				+ refBookingId + ", cultivatorType=" + cultivatorType + ", anubhavadarExtent=" + anubhavadarExtent
				+ ", crDistCode=" + crDistCode + ", crMandCode=" + crMandCode + "]";
	}

}
