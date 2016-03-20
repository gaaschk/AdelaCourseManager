package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class GradeBook {
	private Long gradeBookEntityId;
	private Integer numerOfSemester;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getGradeBookEntityId() {
		return gradeBookEntityId;
	}
	public void setGradeBookEntityId(Long gradeBookEntityId) {
		this.gradeBookEntityId = gradeBookEntityId;
	}
	public Integer getNumerOfSemester() {
		return numerOfSemester;
	}
	public void setNumerOfSemester(Integer numerOfSemester) {
		this.numerOfSemester = numerOfSemester;
	}
	
	
	
	
}
