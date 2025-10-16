//package com.ecrops.util;
//
////import lombok.Getter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
////@Getter
//public class ICICIUtil {
//	
//    @Value("${icici.SECURE_SECRET}")
//    private String secureSecret;
//
//    @Value("${icici.VERSION}")
//    private String version;
//
//    @Value("${icici.PASSCODE}")
//    private String passcode;
//
//    @Value("${icici.BANKID}")
//    private String BankID;
//
//    @Value("${icici.TERMINALID}")
//    private String TerminalId;
//
//    @Value("${icici.MERCHANTID}")
//    private String merchantId;
//
//    @Value("${icici.MCC}")
//    private String mcc;
//
//    @Value("${icici.GATEWAYURL}")
//    private String gateWayUrl;
//
//    @Value("${icici.RETURNURL}")
//    private String returnUrl;
//
//    @Value("${icici.TXNTYPE}")
//    private String txnType;
//
//    @Value("${icici.STATUSTYPE}")
//    private String statusType;
//
//    @Value("${icici.REFUNDTYPE}")
//    private String refundType;
//
//    @Value("${icici.REFUNDSTATUSTYPE}")
//    private String refundStatusType;
//
//    @Value("${icici.ENCKEY}")
//    private String encKey;
//
//    @Value("${icici.STATUS_CHECK_GATEWAY}")
//    private String statusCheckGateWay;
//
//    @Value("${icici.REFUND_GATEWAY}")
//    private String refundGateWay;
//
//    @Value("${icici.CURRENCY}")
//    private String currency;
//    
//    public String getSecureSecret() {
//		return secureSecret;
//	}
//
//	public void setSecureSecret(String secureSecret) {
//		this.secureSecret = secureSecret;
//	}
//
//	public String getVersion() {
//		return version;
//	}
//
//	public void setVersion(String version) {
//		this.version = version;
//	}
//
//	public String getPasscode() {
//		return passcode;
//	}
//
//	public void setPasscode(String passcode) {
//		this.passcode = passcode;
//	}
//
//	public String getBankID() {
//		return BankID;
//	}
//
//	public void setBankID(String bankID) {
//		BankID = bankID;
//	}
//
//	public String getTerminalId() {
//		return TerminalId;
//	}
//
//	public void setTerminalId(String terminalId) {
//		TerminalId = terminalId;
//	}
//
//	public String getMerchantId() {
//		return merchantId;
//	}
//
//	public void setMerchantId(String merchantId) {
//		this.merchantId = merchantId;
//	}
//
//	public String getMcc() {
//		return mcc;
//	}
//
//	public void setMcc(String mcc) {
//		this.mcc = mcc;
//	}
//
//	public String getGateWayUrl() {
//		return gateWayUrl;
//	}
//
//	public void setGateWayUrl(String gateWayUrl) {
//		this.gateWayUrl = gateWayUrl;
//	}
//
//	public String getReturnUrl() {
//		return returnUrl;
//	}
//
//	public void setReturnUrl(String returnUrl) {
//		this.returnUrl = returnUrl;
//	}
//
//	public String getTxnType() {
//		return txnType;
//	}
//
//	public void setTxnType(String txnType) {
//		this.txnType = txnType;
//	}
//
//	public String getStatusType() {
//		return statusType;
//	}
//
//	public void setStatusType(String statusType) {
//		this.statusType = statusType;
//	}
//
//	public String getRefundType() {
//		return refundType;
//	}
//
//	public void setRefundType(String refundType) {
//		this.refundType = refundType;
//	}
//
//	public String getRefundStatusType() {
//		return refundStatusType;
//	}
//
//	public void setRefundStatusType(String refundStatusType) {
//		this.refundStatusType = refundStatusType;
//	}
//
//	public String getEncKey() {
//		return encKey;
//	}
//
//	public void setEncKey(String encKey) {
//		this.encKey = encKey;
//	}
//
//	public String getStatusCheckGateWay() {
//		return statusCheckGateWay;
//	}
//
//	public void setStatusCheckGateWay(String statusCheckGateWay) {
//		this.statusCheckGateWay = statusCheckGateWay;
//	}
//
//	public String getRefundGateWay() {
//		return refundGateWay;
//	}
//
//	public void setRefundGateWay(String refundGateWay) {
//		this.refundGateWay = refundGateWay;
//	}
//
//	public String getCurrency() {
//		return currency;
//	}
//
//	public void setCurrency(String currency) {
//		this.currency = currency;
//	}
//
//	@Override
//	public String toString() {
//		return "ICICIUtil [secureSecret=" + secureSecret + ", version=" + version + ", passcode=" + passcode
//				+ ", BankID=" + BankID + ", TerminalId=" + TerminalId + ", merchantId=" + merchantId + ", mcc=" + mcc
//				+ ", gateWayUrl=" + gateWayUrl + ", returnUrl=" + returnUrl + ", txnType=" + txnType + ", statusType="
//				+ statusType + ", refundType=" + refundType + ", refundStatusType=" + refundStatusType + ", encKey="
//				+ encKey + ", statusCheckGateWay=" + statusCheckGateWay + ", refundGateWay=" + refundGateWay
//				+ ", currency=" + currency + "]";
//	}
//
//	public ICICIUtil(String secureSecret, String version, String passcode, String bankID, String terminalId,
//			String merchantId, String mcc, String gateWayUrl, String returnUrl, String txnType, String statusType,
//			String refundType, String refundStatusType, String encKey, String statusCheckGateWay, String refundGateWay,
//			String currency) {
//		super();
//		this.secureSecret = secureSecret;
//		this.version = version;
//		this.passcode = passcode;
//		BankID = bankID;
//		TerminalId = terminalId;
//		this.merchantId = merchantId;
//		this.mcc = mcc;
//		this.gateWayUrl = gateWayUrl;
//		this.returnUrl = returnUrl;
//		this.txnType = txnType;
//		this.statusType = statusType;
//		this.refundType = refundType;
//		this.refundStatusType = refundStatusType;
//		this.encKey = encKey;
//		this.statusCheckGateWay = statusCheckGateWay;
//		this.refundGateWay = refundGateWay;
//		this.currency = currency;
//	}
//
//	public ICICIUtil() {
//    	
//    }
//}
