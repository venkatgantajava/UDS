package com.ecrops.model;

import java.util.List;

public class FarmerDetails {
	
	
	    private Long applicationId;
	    private String vsdName;
	    private String vsmName;
	    private String vsName;
	    private String farmerId;
	    private String farmerName;
	    private String farmerFname;
	    private String mobileNo;
	    private String gender;  // Consider 'Male' or 'Female'
	    private String address;
	    private String farmerType;
	    private String bankName;
	    private String ifscCode;
	    private String bankBranch;
	    private String accountNo;
	    
	     private String adhar;
	    // Getters and Setters
   //    private List<LandDetails> landDetails;
       
       
	     private   MasterDetails masterdeatils;

       
       
	    
	    public MasterDetails getMasterdeatils() {
		return masterdeatils;
	}










	public void setMasterdeatils(MasterDetails masterDetails) {
		this.masterdeatils = masterDetails;
	}










		public String getAdhar() {
		return adhar;
	}










	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}










		public FarmerDetails() {
			// TODO Auto-generated constructor stub
		}
	    
	    
	







		public Long getApplicationId() {
	        return applicationId;
	    }

	    public void setApplicationId(Long applicationId) {
	        this.applicationId = applicationId;
	    }

	    public String getVsdName() {
	        return vsdName;
	    }

	    public void setVsdName(String vsdName) {
	        this.vsdName = vsdName;
	    }

	    public String getVsmName() {
	        return vsmName;
	    }

	    public void setVsmName(String vsmName) {
	        this.vsmName = vsmName;
	    }

	    public String getVsName() {
	        return vsName;
	    }

	    public void setVsName(String vsName) {
	        this.vsName = vsName;
	    }

	    public String getFarmerId() {
	        return farmerId;
	    }

	    public void setFarmerId(String farmerId) {
	        this.farmerId = farmerId;
	    }

	    public String getFarmerName() {
	        return farmerName;
	    }

	    public void setFarmerName(String farmerName) {
	        this.farmerName = farmerName;
	    }

	    public String getFarmerFname() {
	        return farmerFname;
	    }

	    public void setFarmerFname(String farmerFname) {
	        this.farmerFname = farmerFname;
	    }

	    public String getMobileNo() {
	        return mobileNo;
	    }

	    public void setMobileNo(String mobileNo) {
	        this.mobileNo = mobileNo;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getFarmerType() {
	        return farmerType;
	    }

	    public void setFarmerType(String farmerType) {
	        this.farmerType = farmerType;
	    }

	    public String getBankName() {
	        return bankName;
	    }

	    public void setBankName(String bankName) {
	        this.bankName = bankName;
	    }

	    public String getIfscCode() {
	        return ifscCode;
	    }

	    public void setIfscCode(String ifscCode) {
	        this.ifscCode = ifscCode;
	    }

	    public String getBankBranch() {
	        return bankBranch;
	    }

	    public void setBankBranch(String bankBranch) {
	        this.bankBranch = bankBranch;
	    }

	    public String getAccountNo() {
	        return accountNo;
	    }

	    public void setAccountNo(String accountNo) {
	        this.accountNo = accountNo;
	    }

//		public List<LandDetails> getLandDetails() {
//			return landDetails;
//		}
//
//		public void setLandDetails(List<LandDetails> landDetails) {
//			this.landDetails = landDetails;
//		}

		
	









		@Override
		public String toString() {
			return "FarmerDetails [applicationId=" + applicationId + ", vsdName=" + vsdName + ", vsmName=" + vsmName
					+ ", vsName=" + vsName + ", farmerId=" + farmerId + ", farmerName=" + farmerName + ", farmerFname="
					+ farmerFname + ", mobileNo=" + mobileNo + ", gender=" + gender + ", address=" + address
					+ ", farmerType=" + farmerType + ", bankName=" + bankName + ", ifscCode=" + ifscCode
					+ ", bankBranch=" + bankBranch + ", accountNo=" + accountNo + ", adhar=" + adhar
					+ ", masterdeatils=" + masterdeatils + "]";
		}





	    
}
