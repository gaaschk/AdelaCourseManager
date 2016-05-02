package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ClassDetails {
	private Long idClassDetails;
	private ClassEntity classEntity;
	private SchoolYear schoolYear;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdDetailsClass() {
		return idClassDetails;
	}
	public void setIdDetailsClass(Long idClassDetails) {
		this.idClassDetails = idClassDetails;
	}
	@ManyToOne
	public ClassEntity getClassEntity() {
		return classEntity;
	}
	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}
	@ManyToOne
	public SchoolYear getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(SchoolYear schoolYear) {
		this.schoolYear = schoolYear;
	}

}
