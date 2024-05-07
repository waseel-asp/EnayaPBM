package com.enayapbm.ui;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.enayapbm.business.PbmDataFeedbackMessage;
import com.enayapbm.business.PbmDataOperations;


@Named
@ViewScoped
public class UploadEnayaPbmDataBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String directoryPath;
	private List<PbmDataFeedbackMessage> feedbackList;
	@Inject
	private PbmDataOperations pbmDataOperation;
	
	@PostConstruct
	public void init() {
		feedbackList = new ArrayList<PbmDataFeedbackMessage>();
	}
	
	public void uploadPBMdata() throws FileNotFoundException{
		//LogUtil.log("uploading PriceList for payer: "+ payerId, Level.INFO, null);
		String replacedDirectoryPath = directoryPath.replace("\\","/");
		feedbackList = pbmDataOperation.handleMultipleFileUpload(replacedDirectoryPath);
		if (feedbackList == null){
			 FacesContext context = FacesContext.getCurrentInstance();
		     context.addMessage(null, new FacesMessage("Invalid",  "No pricelists found.") );
		}
	}

	public String getDirectoryPath() {
		return directoryPath;
	}

	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}

	public List<PbmDataFeedbackMessage> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(List<PbmDataFeedbackMessage> feedbackList) {
		this.feedbackList = feedbackList;
	}

}
