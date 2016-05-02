package org.adela.is.awesome.coursemanager.persistence.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {
	
	private Long courseEntityId;
	private String courseName;
	private List<TeacherEntity> teachers;
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
	@OneToMany
	public List<TeacherEntity> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<TeacherEntity> teachers) {
		this.teachers = teachers;
	} 

}
