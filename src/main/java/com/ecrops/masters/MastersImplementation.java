package com.ecrops.masters;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import groovy.transform.Generated;

@Entity
@Table(name="mast_implement_types",schema ="farmmechanization")
public class MastersImplementation {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="impltype_id")
	private  int  implementid;
	
	@Column(name="impltype_name")
	private String implementname;
	
	@Column(name="dt_crt")
	private LocalDateTime  datecrt;
	
	@Column(name="dt_upd")
	private LocalDateTime  dateupdt;
	
	@Column(name="status")
	private  char status;
	
	
public MastersImplementation() {
	// TODO Auto-generated constructor stub
}
	public int getImplementid() {
		return implementid;
	}

	public void setImplementid(int implementid) {
		this.implementid = implementid;
	}

	public String getImplementname() {
		return implementname;
	}

	public void setImplementname(String implementname) {
		this.implementname = implementname;
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

	
	
	
	


}


