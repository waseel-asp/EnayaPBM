package com.enayapbm.medimpact.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "code", "message" })
public class MedImpactCancellationResponse {

	@JsonProperty("code")
	private Integer code;
	@JsonProperty("message")
	private String message;
	
	private int httpStatusCode;
	private String httpStatusDescription;
	

	public MedImpactCancellationResponse(int status, String httpDescriptionForError) {
		this.setHttpStatusCode(status);
		this.setHttpStatusDescription(httpDescriptionForError);
	}
	
//	public MedImpactCancellationResponse() {
//	}

//	public CancellationResponsePbm decompose() {
//		CancellationResponsePbm cancellationResponsePbm = new CancellationResponsePbm();
//		cancellationResponsePbm.setCode(code);
//		cancellationResponsePbm.setMessage(message);
//		return cancellationResponsePbm;
//	}


	@JsonProperty("code")
	public Integer getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(Integer code) {
		this.code = code;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
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