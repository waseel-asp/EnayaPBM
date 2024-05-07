package com.enayapbm.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class RequestPbm {

	private String requestId;
	private Date dateOfService;

	private String payerId;
	private String pharmacyId;
	private Gender gender;
	private String memberId;
	private String weight;
	private Date dateOfBirth;

	private String prescriberId;
	private List<String> diagnosis;
	private List<Service> services;

	public enum Gender {
		MALE, FEMALE
	};

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Date getDateOfService() {
		return dateOfService;
	}

	public void setDateOfService(Date dateOfService) {
		this.dateOfService = dateOfService;
	}

	public String getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(String pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPrescriberId() {
		return prescriberId;
	}

	public void setPrescriberId(String prescriberId) {
		this.prescriberId = prescriberId;
	}

	public List<String> getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(List<String> diagnosis) {
		this.diagnosis = diagnosis;
	}

	public List<Service> getServices() {
		return services;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public static class Service {
		private String serviceCode;
		private BigDecimal requestedQuantity;
		private BigDecimal serviceGrossAmount;
		private String daysOfSupply;

		public String getServiceCode() {
			return serviceCode;
		}

		public void setServiceCode(String serviceCode) {
			this.serviceCode = serviceCode;
		}

		public BigDecimal getRequestedQuantity() {
			return requestedQuantity;
		}

		public void setRequestedQuantity(BigDecimal requestedQuantity) {
			this.requestedQuantity = requestedQuantity;
		}

		public BigDecimal getServiceGrossAmount() {
			return serviceGrossAmount;
		}

		public void setServiceGrossAmount(BigDecimal serviceGrossAmount) {
			this.serviceGrossAmount = serviceGrossAmount;
		}

		public String getDaysOfSupply() {
			return daysOfSupply;
		}

		public void setDaysOfSupply(String daysOfSupply) {
			this.daysOfSupply = daysOfSupply;
		}
	}
}
