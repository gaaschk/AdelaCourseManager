package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StudentDetails {
private Long idStudentDetails;
private ClassDetails classDetails;
private StudentEntity studentEntity;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Long getIdStudentDetails() {
	return idStudentDetails;
}
public void setIdStudentDetails(Long idStudentDetails) {
	this.idStudentDetails = idStudentDetails;
}
@ManyToOne
public ClassDetails getClassDetails() {
	return classDetails;
}
public void setClassDetails(ClassDetails classDetails) {
	this.classDetails = classDetails;
}
@ManyToOne
public StudentEntity getStudentEntity() {
	return studentEntity;
}
public void setStudentEntity(StudentEntity studentEntity) {
	this.studentEntity = studentEntity;
}


	
	
}
