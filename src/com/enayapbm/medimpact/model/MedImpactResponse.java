package com.enayapbm.medimpact.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestId", "status", "errors", "results" })
public class MedImpactResponse{

	@JsonProperty("requestId")
	private String requestId;
	@JsonProperty("status")
	private String status;
	@JsonProperty("errors")
	private List<String> errors = null;
	@JsonProperty("results")
	private List<Result> results = null;
	
	private int httpStatusCode;
	private String httpStatusDescription;
	
	public MedImpactResponse() {
		super();
	}

	public MedImpactResponse(int httpStatusCode, String httpStatusDescription,String requestId) {
		this.requestId = requestId;
		this.httpStatusCode = httpStatusCode;
		this.httpStatusDescription = httpStatusDescription;
	}

	public MedImpactResponse(String requestId) {
		this.requestId = requestId;
	}

	@JsonProperty("requestId")
	public String getRequestId() {
		return requestId;
	}

	@JsonProperty("requestId")
	public void setRequestId(String requestId) {
		this.requestId = requestId;
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
	public List<String> getErrors() {
		return errors;
	}

	@JsonProperty("errors")
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@JsonProperty("results")
	public List<Result> getResults() {
		return results;
	}

	@JsonProperty("results")
	public void setResults(List<Result> results) {
		this.results = results;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getHttpStatusDescription() {
		return httpStatusDescription;
	}

	public void setHttpStatusDescription(String httpStatusDescription) {
		this.httpStatusDescription = httpStatusDescription;
	}
}