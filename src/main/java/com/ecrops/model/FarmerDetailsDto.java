package com.ecrops.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class FarmerDetailsDto {

	private Integer applicationId;
	private String vsdName;
	private String vsmName;
	private String vsName;
	private String farmerId;
	private String farmerName;
	private String farmerFname;
	private String mobileNo;
	private Character gender;
	private String address;
	private String bankName;
	private String ifscCode;
	private String bankBranch;
	private String accountNo;
	private String adhar;
	private String wbedname;
	private String wbemname;
	private String wbvname;
	private String farmeruid;
	private String implementsType;
	private String implement;
	private Integer quantity;
	private String impltype_name;
	private Date time;

	private String payorder_release_dt;
	private String pur_total_cost;

	private String po_number;

	private String impName;

	private String manufacturer;
	private String model;

	private String dealer;

	private String fullcost;
	private String subsidy;

	private String nonSubsidy;

	private String mnf_id;

	private String dealer_id;

	private Integer cgst;
	private Integer sgst;

	private String mnf_name;

	private String model_name;

	private String totamount;

	private Timestamp joint_insp_dt;

	private String farmername;

	private Timestamp dt_invoice;

	private String uid;

	private String caste;

	private String totalvalue;

	private String dt_po;

	private String basicValue;
	private BigDecimal basicCost;

	private String mnf_invoice_upd_no;
	private String mnf_invoice_upd_no_dt;

	private String  dt_uc;
	
	private String mnf_invoice_photo;
	
	
	
	
	public String getDt_uc() {
		return dt_uc;
	}

	public void setDt_uc(String dt_uc) {
		this.dt_uc = dt_uc;
	}

	public String getMnf_invoice_photo() {
		return mnf_invoice_photo;
	}

	public void setMnf_invoice_photo(String mnf_invoice_photo) {
		this.mnf_invoice_photo = mnf_invoice_photo;
	}

	public String getTotalvalue() {
		return totalvalue;
	}

	public void setTotalvalue(String totalvalue) {
		this.totalvalue = totalvalue;
	}

	public String getBasicValue() {
		return basicValue;
	}

	public void setBasicValue(String basicValue) {
		this.basicValue = basicValue;
	}

	public String getTotamount() {
		return totamount;
	}

	public void setTotamount(String totamount) {
		this.totamount = totamount;
	}

	public Timestamp getJoint_insp_dt() {
		return joint_insp_dt;
	}

	public void setJoint_insp_dt(Timestamp joint_insp_dt) {
		this.joint_insp_dt = joint_insp_dt;
	}

	public String getImpltype_name() {
		return impltype_name;
	}

	public void setImpltype_name(String impltype_name) {
		this.impltype_name = impltype_name;
	}

	public String getDealer_id() {
		return dealer_id;
	}

	public void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}

	public String getMnf_id() {
		return mnf_id;
	}

	public void setMnf_id(String mnf_id) {
		this.mnf_id = mnf_id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDealer() {
		return dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public String getFullcost() {
		return fullcost;
	}

	public void setFullcost(String fullcost) {
		this.fullcost = fullcost;
	}

	public String getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(String subsidy) {
		this.subsidy = subsidy;
	}

	public String getNonSubsidy() {
		return nonSubsidy;
	}

	public void setNonSubsidy(String nonSubsidy) {
		this.nonSubsidy = nonSubsidy;
	}

	public String getPo_number() {
		return po_number;
	}

	public void setPo_number(String po_number) {
		this.po_number = po_number;
	}

	public String getImplementsType() {
		return implementsType;
	}

	public void setImplementsType(String implementsType) {
		implementsType = implementsType;
	}

	public String getImplement() {
		return implement;
	}

	public void setImplement(String implement) {
		this.implement = implement;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getFarmeruid() {
		return farmeruid;
	}

	public void setFarmeruid(String farmeruid) {
		this.farmeruid = farmeruid;
	}

	public String getWbedname() {
		return wbedname;
	}

	public void setWbedname(String wbedname) {
		this.wbedname = wbedname;
	}

	public String getWbemname() {
		return wbemname;
	}

	public void setWbemname(String wbemname) {
		this.wbemname = wbemname;
	}

	public String getWbvname() {
		return wbvname;
	}

	public void setWbvname(String wbvname) {
		this.wbvname = wbvname;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
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

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getAdhar() {
		return adhar;
	}

	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}

	public String getImpName() {
		return impName;
	}

	public void setImpName(String impName) {
		this.impName = impName;
	}

	public Integer getCgst() {
		return cgst;
	}

	public void setCgst(Integer cgst) {
		this.cgst = cgst;
	}

	public Integer getSgst() {
		return sgst;
	}

	public void setSgst(Integer sgst) {
		this.sgst = sgst;
	}

	public String getMnf_name() {
		return mnf_name;
	}

	public void setMnf_name(String mnf_name) {
		this.mnf_name = mnf_name;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public String getFarmername() {
		return farmername;
	}

	public void setFarmername(String farmername) {
		this.farmername = farmername;
	}

	public Timestamp getDt_invoice() {
		return dt_invoice;
	}

	public void setDt_invoice(Timestamp dt_invoice) {
		this.dt_invoice = dt_invoice;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public BigDecimal getBasicCost() {
		return basicCost;
	}

	public void setBasicCost(BigDecimal basicCost) {
		this.basicCost = basicCost;
	}

	public String getPayorder_release_dt() {
		return payorder_release_dt;
	}

	public void setPayorder_release_dt(String payorder_release_dt) {
		this.payorder_release_dt = payorder_release_dt;
	}

	public String getPur_total_cost() {
		return pur_total_cost;
	}

	public void setPur_total_cost(String pur_total_cost) {
		this.pur_total_cost = pur_total_cost;
	}

	public String getDt_po() {
		return dt_po;
	}

	public void setDt_po(String dt_po) {
		this.dt_po = dt_po;
	}

	public String getMnf_invoice_upd_no() {
		return mnf_invoice_upd_no;
	}

	public void setMnf_invoice_upd_no(String mnf_invoice_upd_no) {
		this.mnf_invoice_upd_no = mnf_invoice_upd_no;
	}

	public String getMnf_invoice_upd_no_dt() {
		return mnf_invoice_upd_no_dt;
	}

	public void setMnf_invoice_upd_no_dt(String mnf_invoice_upd_no_dt) {
		this.mnf_invoice_upd_no_dt = mnf_invoice_upd_no_dt;
	}

	@Override
	public String toString() {
		return "FarmerDetailsDto [applicationId=" + applicationId + ", vsdName=" + vsdName + ", vsmName=" + vsmName
				+ ", vsName=" + vsName + ", farmerId=" + farmerId + ", farmerName=" + farmerName + ", farmerFname="
				+ farmerFname + ", mobileNo=" + mobileNo + ", gender=" + gender + ", address=" + address + ", bankName="
				+ bankName + ", ifscCode=" + ifscCode + ", bankBranch=" + bankBranch + ", accountNo=" + accountNo
				+ ", adhar=" + adhar + ", wbedname=" + wbedname + ", wbemname=" + wbemname + ", wbvname=" + wbvname
				+ ", farmeruid=" + farmeruid + ", implementsType=" + implementsType + ", implement=" + implement
				+ ", quantity=" + quantity + ", impltype_name=" + impltype_name + ", time=" + time
				+ ", payorder_release_dt=" + payorder_release_dt + ", pur_total_cost=" + pur_total_cost + ", po_number="
				+ po_number + ", impName=" + impName + ", manufacturer=" + manufacturer + ", model=" + model
				+ ", dealer=" + dealer + ", fullcost=" + fullcost + ", subsidy=" + subsidy + ", nonSubsidy="
				+ nonSubsidy + ", mnf_id=" + mnf_id + ", dealer_id=" + dealer_id + ", cgst=" + cgst + ", sgst=" + sgst
				+ ", mnf_name=" + mnf_name + ", model_name=" + model_name + ", totamount=" + totamount
				+ ", joint_insp_dt=" + joint_insp_dt + ", farmername=" + farmername + ", dt_invoice=" + dt_invoice
				+ ", uid=" + uid + ", caste=" + caste + ", totalvalue=" + totalvalue + ", dt_po=" + dt_po
				+ ", basicValue=" + basicValue + ", basicCost=" + basicCost + "]";
	}

}
