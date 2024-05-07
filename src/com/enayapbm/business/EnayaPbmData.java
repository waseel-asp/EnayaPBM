package com.enayapbm.business;

public class EnayaPbmData {
   private String requestId;
   private String invoiceNumber;
   private String payerId;
   private String prescriberId;
   private String physicianName;
   private String memberId;
   private com.enayapbm.business.EnayaPbmData.Gender gender;
   private String providerId;
   private String dateOfService;
   private String dateOfBirth;
   private String diagnosisCode;
   private String sfdaCode;
   private String quantity;
   private String quantityCode;
   private String amount;
   private String daysOfSupply;
   
   public enum Gender {
	   MALE,
	   FEMALE;
	}

   public String getRequestId() {
      return this.requestId;
   }

   public void setRequestId(String requestId) {
      this.requestId = requestId;
   }

   public String getPayerId() {
      return this.payerId;
   }

   public void setPayerId(String payerId) {
      this.payerId = payerId;
   }

   public String getPrescriberId() {
      return this.prescriberId;
   }

   public void setPrescriberId(String prescriberId) {
      this.prescriberId = prescriberId;
   }

   public String getMemberId() {
      return this.memberId;
   }

   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }

   public com.enayapbm.business.EnayaPbmData.Gender getGender() {
      return this.gender;
   }

   public void setGender(com.enayapbm.business.EnayaPbmData.Gender gender) {
      this.gender = gender;
   }

   public String getProviderId() {
      return this.providerId;
   }

   public void setProviderId(String providerId) {
      this.providerId = providerId;
   }

   public String getDateOfService() {
      return this.dateOfService;
   }

   public void setDateOfService(String dateOfService) {
      this.dateOfService = dateOfService;
   }

   public String getDateOfBirth() {
      return this.dateOfBirth;
   }

   public void setDateOfBirth(String dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
   }

   public String getQuantity() {
      return this.quantity;
   }

   public void setQuantity(String quantity) {
      this.quantity = quantity;
   }

   public String getAmount() {
      return this.amount;
   }

   public void setAmount(String amount) {
      this.amount = amount;
   }

   public String getDaysOfSupply() {
      return this.daysOfSupply;
   }

   public void setDaysOfSupply(String daysOfSupply) {
      this.daysOfSupply = daysOfSupply;
   }

   public String getDiagnosisCode() {
      return this.diagnosisCode;
   }

   public void setDiagnosisCode(String diagnosisCode) {
      this.diagnosisCode = diagnosisCode;
   }

   public String getSfdaCode() {
      return this.sfdaCode;
   }

   public void setSfdaCode(String sfdaCode) {
      this.sfdaCode = sfdaCode;
   }

   public String getInvoiceNumber() {
      return this.invoiceNumber;
   }

   public void setInvoiceNumber(String invoiceNumber) {
      this.invoiceNumber = invoiceNumber;
   }

   public String getPhysicianName() {
      return this.physicianName;
   }

   public void setPhysicianName(String physicianName) {
      this.physicianName = physicianName;
   }

   public String getQuantityCode() {
      return this.quantityCode;
   }

   public void setQuantityCode(String quantityCode) {
      this.quantityCode = quantityCode;
   }
}
