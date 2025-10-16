package com.ecrops.projection;

public interface DistrictSubsidySummary {
	String getDistrict();

	String getMandal();
	String getRsk();
	String getMao();
	    
	    Long getTotappl();       // corresponds to sum(totapplications)
	    
	    Long getTotmaoappr();    // corresponds to sum(maoappr)
	    
	    Long getTotadaappr();    // corresponds to sum(adaappr)
	    
	    Long getTotdaoappr(); 
}
