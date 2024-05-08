package com.enayapbm.persist;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * PbmconfigPayerToProvider entity. @author MyEclipse Persistence Tools
 */
//@Entity
//@Table(name = "PBMConfigPayerToProvider", schema = "HIRA")

public class PbmconfigPayerToProvider implements java.io.Serializable {

	// Fields

	private PbmconfigPayerToProviderId id;
	private String isEnabled;

	// Constructors

	/** default constructor */
	public PbmconfigPayerToProvider() {
	}

	/** full constructor */
	public PbmconfigPayerToProvider(PbmconfigPayerToProviderId id, String isEnabled) {
		this.id = id;
		this.isEnabled = isEnabled;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "payerId", column = @Column(name = "PayerId", nullable = false, length = 100) ),
			@AttributeOverride(name = "providerId", column = @Column(name = "ProviderId", nullable = false, length = 100) ) })

	public PbmconfigPayerToProviderId getId() {
		return this.id;
	}

	public void setId(PbmconfigPayerToProviderId id) {
		this.id = id;
	}

	@Column(name = "isEnabled", nullable = false, length = 1)

	public String getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

}