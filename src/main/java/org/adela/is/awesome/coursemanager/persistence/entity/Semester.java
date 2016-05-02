package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Semester {
private Long idSemester;
private String tytleSemester;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Long getIdSemester() {
	return idSemester;
}
public void setIdSemester(Long idSemester) {
	this.idSemester = idSemester;
}
public String getTytleSemester() {
	return tytleSemester;
}
public void setTytleSemester(String tytleSemester) {
	this.tytleSemester = tytleSemester;
}

}
