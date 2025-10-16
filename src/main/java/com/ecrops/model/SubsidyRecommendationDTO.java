package com.ecrops.model;



import java.math.BigDecimal;

public class SubsidyRecommendationDTO {
    private String wbedName;
    private String wbemName;
    private String wbevName;
    private String implTypeName;
    private String modelName;
    private String mnfName;
    private String dealerName;
    private int fullCost;
    private BigDecimal subsidyAmt;
    private int applicationId;   
    private String po_number;
    private int quantity;
    private String implName;
    private String invoice;
    private String dtInvoice;
    
    private String invoice_photo;
    private String jir_photo;
    private String uc_photo;
    
    
    




    public String getInvoice_photo() {
		return invoice_photo;
	}

	public void setInvoice_photo(String invoice_photo) {
		this.invoice_photo = invoice_photo;
	}

	public String getJir_photo() {
		return jir_photo;
	}

	public void setJir_photo(String jir_photo) {
		this.jir_photo = jir_photo;
	}

	public String getUc_photo() {
		return uc_photo;
	}

	public void setUc_photo(String uc_photo) {
		this.uc_photo = uc_photo;
	}

	public String getPo_number() {
		return po_number;
	}

	public void setPo_number(String po_number) {
		this.po_number = po_number;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public SubsidyRecommendationDTO() {}

   

    public SubsidyRecommendationDTO(String wbedName, String wbemName, String wbevName, String implTypeName,
			String modelName, String mnfName, String dealerName, int fullCost, BigDecimal subsidyAmt,
			int applicationId) {
		super();
		this.wbedName = wbedName;
		this.wbemName = wbemName;
		this.wbevName = wbevName;
		this.implTypeName = implTypeName;
		this.modelName = modelName;
		this.mnfName = mnfName;
		this.dealerName = dealerName;
		this.fullCost = fullCost;
		this.subsidyAmt = subsidyAmt;
		this.applicationId = applicationId;
	}

	// Getters and Setters
    public String getWbedName() { return wbedName; }
    public void setWbedName(String wbedName) { this.wbedName = wbedName; }

    public String getWbemName() { return wbemName; }
    public void setWbemName(String wbemName) { this.wbemName = wbemName; }

    public String getWbevName() { return wbevName; }
    public void setWbevName(String wbevName) { this.wbevName = wbevName; }

    public String getImplTypeName() { return implTypeName; }
    public void setImplTypeName(String implTypeName) { this.implTypeName = implTypeName; }

    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }

    public String getMnfName() { return mnfName; }
    public void setMnfName(String mnfName) { this.mnfName = mnfName; }

    public String getDealerName() { return dealerName; }
    public void setDealerName(String dealerName) { this.dealerName = dealerName; }

    public int getFullCost() { return fullCost; }
    public void setFullCost(int fullCost) { this.fullCost = fullCost; }

    public BigDecimal getSubsidyAmt() { return subsidyAmt; }
    public void setSubsidyAmt(BigDecimal subsidyAmt) { this.subsidyAmt = subsidyAmt; }

	public String getImplName() {
		return implName;
	}

	public void setImplName(String implName) {
		this.implName = implName;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getDtInvoice() {
		return dtInvoice;
	}

	public void setDtInvoice(String dtInvoice) {
		this.dtInvoice = dtInvoice;
	}
    
}
