package com.enayapbm.persist;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PbmconfigPayerToProviderId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class PbmconfigPayerToProviderId implements java.io.Serializable {

	// Fields

	private String payerId;
	private String providerId;

	// Constructors

	/** default constructor */
	public PbmconfigPayerToProviderId() {
	}

	/** full constructor */
	public PbmconfigPayerToProviderId(String payerId, String providerId) {
		this.payerId = payerId;
		this.providerId = providerId;
	}

	// Property accessors

	@Column(name = "PayerId", nullable = false, length = 100)

	public String getPayerId() {
		return this.payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	@Column(name = "ProviderId", nullable = false, length = 100)

	public String getProviderId() {
		return this.providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PbmconfigPayerToProviderId))
			return false;
		PbmconfigPayerToProviderId castOther = (PbmconfigPayerToProviderId) other;

		return ((this.getPayerId() == castOther.getPayerId()) || (this.getPayerId() != null
				&& castOther.getPayerId() != null && this.getPayerId().equals(castOther.getPayerId())))
				&& ((this.getProviderId() == castOther.getProviderId())
						|| (this.getProviderId() != null && castOther.getProviderId() != null
								&& this.getProviderId().equals(castOther.getProviderId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPayerId() == null ? 0 : this.getPayerId().hashCode());
		result = 37 * result + (getProviderId() == null ? 0 : this.getProviderId().hashCode());
		return result;
	}

}