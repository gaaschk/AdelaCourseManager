package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentEntity {
	private Long studentEntityId;
	private String studentName; 
	private Integer registerYear;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getStudentEntityId() {
		return studentEntityId;
	}
	public void setStudentEntityId(Long studentEntityId) {
		this.studentEntityId = studentEntityId;
	}

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getRegisterYear() {
		return registerYear;
	}
	public void setRegisterYear(Integer registerYear) {
		this.registerYear = registerYear;
	}
	
}
