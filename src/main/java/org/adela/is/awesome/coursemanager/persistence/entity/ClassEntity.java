package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClassEntity {
	private Long classEntityId;
	private String identifier;

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

}
