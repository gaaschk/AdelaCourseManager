package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProfileOfClass {
	private Long profileEntityId;
	private String profileName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getProfileEntityId() {
		return profileEntityId;
	}

	public void setProfileEntityId(Long profileEntityId) {
		this.profileEntityId = profileEntityId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
}
