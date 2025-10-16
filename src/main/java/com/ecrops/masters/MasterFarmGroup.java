package com.ecrops.masters;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mast_farmer_grp", schema = "farmmechanization")
public class MasterFarmGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grp_id")
	private Integer groupid;

	@Column(name = "grp_name")
	private String groupname;

	@Column(name = "dt_crt")
	private LocalDateTime date;

	@Column(name = "status")
	private char sataus;

	@Column(name = "rskcode")
	private String rskcode;
	@Column(name = "vcode")
	private Integer vcode;
	@Column(name = "cropyear")
	private Integer cropyear;

	public MasterFarmGroup() {
		// TODO Auto-generated constructor stub
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public char getSataus() {
		return sataus;
	}

	public void setSataus(char sataus) {
		this.sataus = sataus;
	}

	public String getRskcode() {
		return rskcode;
	}

	public void setRskcode(String rskcode) {
		this.rskcode = rskcode;
	}

	public Integer getVcode() {
		return vcode;
	}

	public void setVcode(Integer vcode) {
		this.vcode = vcode;
	}

	public Integer getCropyear() {
		return cropyear;
	}

	public void setCropyear(Integer cropyear) {
		this.cropyear = cropyear;
	}

	@Override
	public String toString() {
		return "MasterFarmGroup [groupid=" + groupid + ", groupname=" + groupname + ", date=" + date + ", sataus="
				+ sataus + ", rskcode=" + rskcode + ", vcode=" + vcode + ", cropyear=" + cropyear + "]";
	}

}
