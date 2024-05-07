package com.enayapbm.medimpact.delivery;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.enayapbm.config.PbmConfigManager;
import com.enayapbm.medimpact.model.MedImpactRequest;
import com.enayapbm.medimpact.model.MedImpactResponse;

@RequestScoped
public class PbmMedimpactDelivery {
	
	@Inject
	private MedimpactRestClientHandler restClientHandler;

	@Inject
	private PbmConfigManager pbmConfigManager;
	
	public MedImpactResponse submitNewRequest(MedImpactRequest requestToMedimpact) {
		prepareRestClientHandlerForNew();
		return restClientHandler.doPostForNewRequest(requestToMedimpact);
	}
	
	private void prepareRestClientHandlerForNew() {
		restClientHandler.prepareHandler(pbmConfigManager.getDssNewApiUrl(),
				pbmConfigManager.getAuthentication_Username_Medimpact(), pbmConfigManager.getAuthentication_Password_Medimpact(),
				Integer.parseInt(pbmConfigManager.getNoOfRetries()), 
					Integer.parseInt(pbmConfigManager.getTimeout()), Integer.parseInt(pbmConfigManager.getTimeout()));
	}

}
