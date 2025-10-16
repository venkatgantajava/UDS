package com.ecrops.dto;

public class VillageDTO {
	private int wbvcode;
    private String wbvname;
	public int getWbvcode() {
		return wbvcode;
	}
	public void setWbvcode(int wbvcode) {
		this.wbvcode = wbvcode;
	}
	public String getWbvname() {
		return wbvname;
	}
	public void setWbvname(String wbvname) {
		this.wbvname = wbvname;
	}
	public VillageDTO(int wbvcode, String wbvname) {
		super();
		this.wbvcode = wbvcode;
		this.wbvname = wbvname;
	}
    
   
}
