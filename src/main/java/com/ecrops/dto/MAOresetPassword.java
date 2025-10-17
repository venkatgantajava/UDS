package com.ecrops.dto;

public class MAOresetPassword {
	
	private String mandalName;
	
	private String distName;
	
	

	public MAOresetPassword() {
		super();
	}

	public MAOresetPassword(String mandalName, String distName) {
		super();
		this.mandalName = mandalName;
		this.distName = distName;
	}

	public String getMandalName() {
		return mandalName;
	}

	public void setMandalName(String mandalName) {
		this.mandalName = mandalName;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}
	
	
	
	
	

}
