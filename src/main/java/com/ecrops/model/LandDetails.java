package com.ecrops.model;

public class LandDetails {

	
	private String surveyNo;
    private String khtNo;
    private Double extent;  // Assuming extent is a numerical value. Adjust type if necessary.
    private String dname;
    private String mname;
    private String vname;
    
    
    public LandDetails() {
		// TODO Auto-generated constructor stub
	}


	public String getSurveyNo() {
		return surveyNo;
	}


	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}


	public String getKhtNo() {
		return khtNo;
	}


	public void setKhtNo(String khtNo) {
		this.khtNo = khtNo;
	}


	public Double getExtent() {
		return extent;
	}


	public void setExtent(Double extent) {
		this.extent = extent;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
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
    
    
    
}
