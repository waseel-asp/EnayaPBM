package com.enayapbm.business;

public class PbmDataFeedbackMessage {

	private String fileName;
	private String feedbackMessage;
	public String getFileName() {
		return fileName;
	}
	
	public PbmDataFeedbackMessage(String fileName, String feedbackMessage){
		this.fileName = fileName;
		this.feedbackMessage = feedbackMessage;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFeedbackMessage() {
		return feedbackMessage;
	}
	public void setFeedbackMessage(String feedbackMessage) {
		this.feedbackMessage = feedbackMessage;
	}
	
}
