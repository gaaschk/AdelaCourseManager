package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
	
	private Long courseEntityId;
	private String courseName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getCourseEntityId() {
		return courseEntityId;
	}
	public void setCourseEntityId(Long courseEntityId) {
		this.courseEntityId = courseEntityId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	} 

}
