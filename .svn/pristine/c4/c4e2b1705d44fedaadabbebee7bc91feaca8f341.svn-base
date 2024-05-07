package com.enayapbm.model;

import java.math.BigDecimal;
import java.util.List;

public class ResponsePbm {

	private String requestId;
	private String status;
	private List<String> errors;
	private List<Service> results;

	public static class Service {
		private String serviceCode;
		private BigDecimal requestedQuantity;
		private BigDecimal serviceGrossAmount;
		private String daysOfSupply;
		private String status;
		private List<String> errors;


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

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<String> getErrors() {
			return errors;
		}

		public void setErrors(List<String> errors) {
			this.errors = errors;
		}
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public List<Service> getResults() {
		return results;
	}

	public void setResults(List<Service> results) {
		this.results = results;
	}

}
