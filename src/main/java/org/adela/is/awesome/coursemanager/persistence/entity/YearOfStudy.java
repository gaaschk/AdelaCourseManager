package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class YearOfStudy {
private Long yearEntityId;
private String yearName;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
public Long getYearEntityId() {
	return yearEntityId;
}
public void setYearEntityId(Long yearEntityId) {
	this.yearEntityId = yearEntityId;
}
public String getYearName() {
	return yearName;
}
public void setYearName(String yearName) {
	this.yearName = yearName;
}


}
