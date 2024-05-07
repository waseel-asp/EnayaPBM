package com.enayapbm.medimpact.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"requestId",
"drugList"
})
public class MedImpactCancellationRequest {

@JsonProperty("requestId")
private String requestId;
@JsonProperty("drugList")
private List<String> drugList = null;

@JsonProperty("requestId")
public String getRequestId() {
return requestId;
}

@JsonProperty("requestId")
public void setRequestId(String requestId) {
this.requestId = requestId;
}

@JsonProperty("drugList")
public List<String> getDrugList() {
return drugList;
}

@JsonProperty("drugList")
public void setDrugList(List<String> drugList) {
this.drugList = drugList;
}



}