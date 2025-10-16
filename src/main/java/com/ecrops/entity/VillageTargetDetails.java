package com.ecrops.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class VillageTargetDetails {
	
	
	private int crop_year;
	private String dname;
	private String impltype_name;
	private String impl_name;
	private int impl_id;
	private int dcode;
	private int scheme_id;
	private int mcode;
	private String mname;
	private String vname;
	private int rskcode;
	private int rsktarg_id;
	private double rsk_target;
	private int implement_type_id;
	
	
	public int getCrop_year() {
		return crop_year;
	}
	public void setCrop_year(int crop_year) {
		this.crop_year = crop_year;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getImpltype_name() {
		return impltype_name;
	}
	public void setImpltype_name(String impltype_name) {
		this.impltype_name = impltype_name;
	}
	public String getImpl_name() {
		return impl_name;
	}
	public void setImpl_name(String impl_name) {
		this.impl_name = impl_name;
	}
	
	public int getDcode() {
		return dcode;
	}
	public void setDcode(int dcode) {
		this.dcode = dcode;
	}
	public int getScheme_id() {
		return scheme_id;
	}
	public void setScheme_id(int scheme_id) {
		this.scheme_id = scheme_id;
	}
	public int getMcode() {
		return mcode;
	}
	public void setMcode(int mcode) {
		this.mcode = mcode;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public int getRskcode() {
		return rskcode;
	}
	public void setRskcode(int rskcode) {
		this.rskcode = rskcode;
	}
	public int getRsktarg_id() {
		return rsktarg_id;
	}
	public void setRsktarg_id(int rsktarg_id) {
		this.rsktarg_id = rsktarg_id;
	}
	public double getRsk_target() {
		return rsk_target;
	}
	public void setRsk_target(double rsk_target) {
		this.rsk_target = rsk_target;
	}
	public int getImplement_type_id() {
		return implement_type_id;
	}
	public void setImplement_type_id(int implement_type_id) {
		this.implement_type_id = implement_type_id;
	}
	public int getImpl_id() {
		return impl_id;
	}
	public void setImpl_id(int impl_id) {
		this.impl_id = impl_id;
	}
	@Override
	public String toString() {
		return "VillageTargetDetails [crop_year=" + crop_year + ", dname=" + dname + ", impltype_name=" + impltype_name
				+ ", impl_name=" + impl_name + ", impl_id=" + impl_id + ", dcode=" + dcode + ", scheme_id=" + scheme_id
				+ ", mcode=" + mcode + ", mname=" + mname + ", vname=" + vname + ", rskcode=" + rskcode
				+ ", rsktarg_id=" + rsktarg_id + ", rsk_target=" + rsk_target + ", implement_type_id="
				+ implement_type_id + "]";
	}
	
	
	
	
	
	
   
}
