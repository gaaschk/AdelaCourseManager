package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ClassEntity {
	private Long classEntityId;
	private String identifier;
	private ProfileOfClass profile;
	private YearOfStudy yearOfStudy;
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getClassEntityId() {
		return classEntityId;
	}

	public void setClassEntityId(Long classEntityId) {
		this.classEntityId = classEntityId;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@ManyToOne
	public ProfileOfClass getProfile() {
		return profile;
	}

	public void setProfile(ProfileOfClass profile) {
		this.profile = profile;
	}

	@ManyToOne
	public YearOfStudy getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(YearOfStudy yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
}
