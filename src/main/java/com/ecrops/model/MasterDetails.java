package com.ecrops.model;

public class MasterDetails {
	
	
	
	 private String implTypeName;
	    private String implName;
	    private Integer quantity; // Assuming quantity is an integer. Adjust if necessary.
	    private Integer cropYear; // Assuming cropYear is an integer representing the year.
	    private char applicationType;
	    private String grpName;

	    // Getters and Setters
    public MasterDetails() {
	// TODO Auto-generated constructor stub
}
	    public String getImplTypeName() {
	        return implTypeName;
	    }

	    public void setImplTypeName(String implTypeName) {
	        this.implTypeName = implTypeName;
	    }

	    public String getImplName() {
	        return implName;
	    }

	    public void setImplName(String implName) {
	        this.implName = implName;
	    }

	    public Integer getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }

	    public Integer getCropYear() {
	        return cropYear;
	    }

	    public void setCropYear(Integer cropYear) {
	        this.cropYear = cropYear;
	    }

	    public char getApplicationType() {
	        return applicationType;
	    }

	    public void setApplicationType(char applicationType) {
	        this.applicationType = applicationType;
	    }

	    public String getGrpName() {
	        return grpName;
	    }

	    public void setGrpName(String grpName) {
	        this.grpName = grpName;
	    }
		@Override
		public String toString() {
			return "MasterDetails [implTypeName=" + implTypeName + ", implName=" + implName + ", quantity=" + quantity
					+ ", cropYear=" + cropYear + ", applicationType=" + applicationType + ", grpName=" + grpName + "]";
		}

}
