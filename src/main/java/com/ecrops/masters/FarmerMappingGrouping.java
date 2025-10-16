package com.ecrops.masters;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FarmerMappingGrouping {

	
	private static final long serialVersionUID = 1L;

    @JsonProperty("appl_no")
    private String appno;

    @JsonProperty("farmer_name")
    private String farmername;

    @JsonProperty("mcode")
    private String mandal;

    @JsonProperty("vcode")
    private String village;

    @JsonProperty("dropwovalue")
    private String dropwovalue;

    // Default constructor
    public FarmerMappingGrouping() {}

    // Getters and setters
    public String getAppno() {
        return appno;
    }

    public void setAppno(String appno) {
        this.appno = appno;
    }

    public String getFarmername() {
        return farmername;
    }

    public void setFarmername(String farmername) {
        this.farmername = farmername;
    }

    public String getMandal() {
        return mandal;
    }

    public void setMandal(String mandal) {
        this.mandal = mandal;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getDropwovalue() {
        return dropwovalue;
    }

    public void setDropwovalue(String dropwovalue) {
        this.dropwovalue = dropwovalue;
    }

    @Override
    public String toString() {
        return "FarmerApplicationDetailsEntity{" +
                "appno='" + appno + '\'' +
                ", farmername='" + farmername + '\'' +
                ", mandal='" + mandal + '\'' +
                ", village='" + village + '\'' +
                ", dropwovalue='" + dropwovalue + '\'' +
                '}';
    }
}
