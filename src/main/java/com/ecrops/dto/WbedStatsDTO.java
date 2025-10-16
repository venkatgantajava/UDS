package com.ecrops.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class WbedStatsDTO {
	private String wbedname;
	private String wbemname;
	private String rbkname;
	private BigInteger implreceivedbyvaa;
    public BigInteger getImplreceivedbyvaa() {
		return implreceivedbyvaa;
	}
	public void setImplreceivedbyvaa(BigInteger implreceivedbyvaa) {
		this.implreceivedbyvaa = implreceivedbyvaa;
	}
	private BigInteger noofmandals;
    private BigInteger noofvillages;
    private BigInteger noofrsks;
    private BigInteger totappls;
    private BigInteger total_fullcost;
    private BigDecimal total_nonsubsidyamt;
    private BigDecimal total_subsidyamt;
    private BigInteger invoice_status;
    private Integer invoice_upload_status;
    private Integer joint_insp_status;
    private BigInteger uc_status;
    private Integer uc_upload_status;
    private Integer subsidyrecommendationbyvaa;
    private Integer subsidyrecommendationbymao;
    private Integer subsidyrecommendationbyada;
    private BigInteger subsidyrecommendationbyagency;
    
    private BigInteger subsidyrecommendationbydao;
    private BigInteger subsidyrec_insp_status_ada;
    
    private BigInteger daosubsidyverify;
    private BigInteger dao_uc_verify;
	
    
    
    
    
   
	
	public BigInteger getSubsidyrec_insp_status_ada() {
		return subsidyrec_insp_status_ada;
	}
	public void setSubsidyrec_insp_status_ada(BigInteger subsidyrec_insp_status_ada) {
		this.subsidyrec_insp_status_ada = subsidyrec_insp_status_ada;
	}
	public BigInteger getDaosubsidyverify() {
		return daosubsidyverify;
	}
	public void setDaosubsidyverify(BigInteger daosubsidyverify) {
		this.daosubsidyverify = daosubsidyverify;
	}
	public BigInteger getDao_uc_verify() {
		return dao_uc_verify;
	}
	public void setDao_uc_verify(BigInteger dao_uc_verify) {
		this.dao_uc_verify = dao_uc_verify;
	}
	public BigInteger getSubsidyrecommendationbydao() {
		return subsidyrecommendationbydao;
	}
	public void setSubsidyrecommendationbydao(BigInteger subsidyrecommendationbydao) {
		this.subsidyrecommendationbydao = subsidyrecommendationbydao;
	}
	public BigInteger getSubsidyrecommendationbyagency() {
		return subsidyrecommendationbyagency;
	}
	public void setSubsidyrecommendationbyagency(BigInteger subsidyrecommendationbyagency) {
		this.subsidyrecommendationbyagency = subsidyrecommendationbyagency;
	}
	public String getRbkname() {
		return rbkname;
	}
	public void setRbkname(String rbkname) {
		this.rbkname = rbkname;
	}
	public String getWbemname() {
		return wbemname;
	}
	public void setWbemname(String wbemname) {
		this.wbemname = wbemname;
	}
	public String getWbedname() {
		return wbedname;
	}
	public void setWbedname(String wbedname) {
		this.wbedname = wbedname;
	}
	public BigInteger getNoofmandals() {
		return noofmandals;
	}
	public void setNoofmandals(BigInteger noofmandals) {
		this.noofmandals = noofmandals;
	}
	public BigInteger getNoofvillages() {
		return noofvillages;
	}
	public void setNoofvillages(BigInteger noofvillages) {
		this.noofvillages = noofvillages;
	}
	public BigInteger getNoofrsks() {
		return noofrsks;
	}
	public void setNoofrsks(BigInteger noofrsks) {
		this.noofrsks = noofrsks;
	}
	public BigInteger getTotappls() {
		return totappls;
	}
	public void setTotappls(BigInteger totappls) {
		this.totappls = totappls;
	}
	public BigInteger getTotal_fullcost() {
		return total_fullcost;
	}
	public void setTotal_fullcost(BigInteger total_fullcost) {
		this.total_fullcost = total_fullcost;
	}
	public BigDecimal getTotal_nonsubsidyamt() {
		return total_nonsubsidyamt;
	}
	public void setTotal_nonsubsidyamt(BigDecimal total_nonsubsidyamt) {
		this.total_nonsubsidyamt = total_nonsubsidyamt;
	}
	public BigDecimal getTotal_subsidyamt() {
		return total_subsidyamt;
	}
	public void setTotal_subsidyamt(BigDecimal total_subsidyamt) {
		this.total_subsidyamt = total_subsidyamt;
	}
	public BigInteger getInvoice_status() {
		return invoice_status;
	}
	public void setInvoice_status(BigInteger invoice_status) {
		this.invoice_status = invoice_status;
	}
	public Integer getInvoice_upload_status() {
		return invoice_upload_status;
	}
	public void setInvoice_upload_status(Integer invoice_upload_status) {
		this.invoice_upload_status = invoice_upload_status;
	}
	public Integer getJoint_insp_status() {
		return joint_insp_status;
	}
	public void setJoint_insp_status(Integer joint_insp_status) {
		this.joint_insp_status = joint_insp_status;
	}
	public BigInteger getUc_status() {
		return uc_status;
	}
	public void setUc_status(BigInteger uc_status) {
		this.uc_status = uc_status;
	}
	public Integer getUc_upload_status() {
		return uc_upload_status;
	}
	public void setUc_upload_status(Integer uc_upload_status) {
		this.uc_upload_status = uc_upload_status;
	}
	public Integer getSubsidyrecommendationbyvaa() {
		return subsidyrecommendationbyvaa;
	}
	public void setSubsidyrecommendationbyvaa(Integer subsidyrecommendationbyvaa) {
		this.subsidyrecommendationbyvaa = subsidyrecommendationbyvaa;
	}
	public Integer getSubsidyrecommendationbymao() {
		return subsidyrecommendationbymao;
	}
	public void setSubsidyrecommendationbymao(Integer subsidyrecommendationbymao) {
		this.subsidyrecommendationbymao = subsidyrecommendationbymao;
	}
	public Integer getSubsidyrecommendationbyada() {
		return subsidyrecommendationbyada;
	}
	public void setSubsidyrecommendationbyada(Integer subsidyrecommendationbyada) {
		this.subsidyrecommendationbyada = subsidyrecommendationbyada;
	}
	@Override
	public String toString() {
		return "WbedStatsDTO [wbedname=" + wbedname + ", noofmandals=" + noofmandals + ", noofvillages=" + noofvillages
				+ ", noofrsks=" + noofrsks + ", totappls=" + totappls + ", total_fullcost=" + total_fullcost
				+ ", total_nonsubsidyamt=" + total_nonsubsidyamt + ", total_subsidyamt=" + total_subsidyamt
				+ ", invoice_status=" + invoice_status + ", invoice_upload_status=" + invoice_upload_status
				+ ", joint_insp_status=" + joint_insp_status + ", uc_status=" + uc_status + ", uc_upload_status="
				+ uc_upload_status + ", subsidyrecommendationbyvaa=" + subsidyrecommendationbyvaa
				+ ", subsidyrecommendationbymao=" + subsidyrecommendationbymao + ", subsidyrecommendationbyada="
				+ subsidyrecommendationbyada + "]";
	}
	
}
