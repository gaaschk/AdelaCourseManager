package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SchoolYear {
private Long idSchoolYear;
private String tytleSchoolYear;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Long getIdSchoolYear() {
	return idSchoolYear;
}
public void setIdSchoolYear(Long idSchoolYear) {
	this.idSchoolYear = idSchoolYear;
}
public String getTytleSchoolYear() {
	return tytleSchoolYear;
}
public void setTytleSchoolYear(String tytleSchoolYear) {
	this.tytleSchoolYear = tytleSchoolYear;
}	
}
