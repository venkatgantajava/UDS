package com.ecrops.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "villsec_rev_v")
public class VillageSec {

	@Id
	@Column(name = "vcode")
	private Integer vcode;

	@Column(name = "wbvname")
	private String wbvname;
	
	@Column(name = "vscode")
	private Integer vscode;

	@Column(name = "vsname")
	private String vsname;

	public Integer getVcode() {
		return vcode;
	}

	public void setVcode(Integer vcode) {
		this.vcode = vcode;
	}

	public String getWbvname() {
		return wbvname;
	}

	public void setWbvname(String wbvname) {
		this.wbvname = wbvname;
	}

	public Integer getVscode() {
		return vscode;
	}

	public void setVscode(Integer vscode) {
		this.vscode = vscode;
	}

	public String getVsname() {
		return vsname;
	}

	public void setVsname(String vsname) {
		this.vsname = vsname;
	}

	@Override
	public String toString() {
		return "VillageSec [vcode=" + vcode + ", wbvname=" + wbvname + ", vscode=" + vscode + ", vsname=" + vsname
				+ "]";
	}
	
	
}