package com.enayapbm.business;

import java.util.Date;
import java.util.List;

public class EnayaPbmData2 {
	private String requestId;
	private String payerId;
	private String prescriberId;
	private String policyNo;
	private String memberNo;
	private String memberId;
	private Gender gender;
	private String providerId;
	private String providerName;
	private Date approvalReceivedDate;
	private Date dateOfService;
	private Date dateOfBirth;
	private String diagnosisCode;
	private String diagnosisDesc;
	private String sfdaCode;
	private Integer dispensedQuantity;
	private Double amount;
	private String daysOfSupply;
	
	public enum Gender {
		MALE, FEMALE
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public String getPrescriberId() {
		return prescriberId;
	}

	public void setPrescriberId(String prescriberId) {
		this.prescriberId = prescriberId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public Date getDateOfService() {
		return dateOfService;
	}

	public void setDateOfService(Date dateOfService) {
		this.dateOfService = dateOfService;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	

	public Integer getDispensedQuantity() {
		return dispensedQuantity;
	}

	public void setDispensedQuantity(Integer dispensedQuantity) {
		this.dispensedQuantity = dispensedQuantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDaysOfSupply() {
		return daysOfSupply;
	}

	public void setDaysOfSupply(String daysOfSupply) {
		this.daysOfSupply = daysOfSupply;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Date getApprovalReceivedDate() {
		return approvalReceivedDate;
	}

	public void setApprovalReceivedDate(Date approvalReceivedDate) {
		this.approvalReceivedDate = approvalReceivedDate;
	}

	public String getDiagnosisCode() {
		return diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getDiagnosisDesc() {
		return diagnosisDesc;
	}

	public void setDiagnosisDesc(String diagnosisDesc) {
		this.diagnosisDesc = diagnosisDesc;
	}

	public String getSfdaCode() {
		return sfdaCode;
	}

	public void setSfdaCode(String sfdaCode) {
		this.sfdaCode = sfdaCode;
	}

	
	
	

}
