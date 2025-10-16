package com.ecrops.masters;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
@Table(name="mast_manufacturers",schema ="farmmechanization")
public class MasterManufacturers {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mnf_id")
	private  Integer  mid;
	
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Only alphanumeric characters are allowed")
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")

	@Column(name="mnf_name")
	private String mname;
	
	
	@Column(name="impl_id")
	private  int  impid;
	
	@Column(name="dt_crt")
	private LocalDateTime  datecrt;
	
	@Column(name="dt_upd")
	private LocalDateTime  dateupdt;
	
	@Column(name="status")
	private  char status;
	
	public MasterManufacturers() {
		// TODO Auto-generated constructor stub
	}



	public Integer getMid() {
		return mid;
	}



	public void setMid(Integer mid) {
		this.mid = mid;
	}



	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getImpid() {
		return impid;
	}

	public void setImpid(int impid) {
		this.impid = impid;
	}

	public LocalDateTime getDatecrt() {
		return datecrt;
	}

	public void setDatecrt(LocalDateTime datecrt) {
		this.datecrt = datecrt;
	}

	public LocalDateTime getDateupdt() {
		return dateupdt;
	}

	public void setDateupdt(LocalDateTime dateupdt) {
		this.dateupdt = dateupdt;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "MasterManufacturers [mid=" + mid + ", mname=" + mname + ", impid=" + impid + ", datecrt=" + datecrt
				+ ", dateupdt=" + dateupdt + ", status=" + status + "]";
	}

	
	
	
	
}
