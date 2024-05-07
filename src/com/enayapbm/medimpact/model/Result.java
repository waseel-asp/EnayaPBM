package com.enayapbm.medimpact.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ndcDrugCode", "dispensedQuantity", "amount", "daysOfSupply", "status", "errors" })
public class Result {

	@JsonProperty("ndcDrugCode")
	private String ndcDrugCode;
	@JsonProperty("dispensedQuantity")
	private Integer dispensedQuantity;
	@JsonProperty("amount")
	private String amount;
	@JsonProperty("daysOfSupply")
	private String daysOfSupply;
	@JsonProperty("status")
	private String status;
	@JsonProperty("errors")
	private List<Error> errors = null;

	@JsonProperty("ndcDrugCode")
	public String getNdcDrugCode() {
		return ndcDrugCode;
	}

	@JsonProperty("ndcDrugCode")
	public void setNdcDrugCode(String ndcDrugCode) {
		this.ndcDrugCode = ndcDrugCode;
	}

	@JsonProperty("dispensedQuantity")
	public Integer getDispensedQuantity() {
		return dispensedQuantity;
	}

	@JsonProperty("dispensedQuantity")
	public void setDispensedQuantity(Integer dispensedQuantity) {
		this.dispensedQuantity = dispensedQuantity;
	}

	@JsonProperty("amount")
	public String getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(String amount) {
		this.amount = amount;
	}

	@JsonProperty("daysOfSupply")
	public String getDaysOfSupply() {
		return daysOfSupply;
	}

	@JsonProperty("daysOfSupply")
	public void setDaysOfSupply(String daysOfSupply) {
		this.daysOfSupply = daysOfSupply;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("errors")
	public List<Error> getErrors() {
		return errors;
	}

	@JsonProperty("errors")
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

}
