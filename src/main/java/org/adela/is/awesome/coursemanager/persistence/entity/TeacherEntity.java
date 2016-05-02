package org.adela.is.awesome.coursemanager.persistence.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TeacherEntity {
	private Long teacherEntityId;
	private String teacherName; 
	private List<Course> courses;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getTeacherEntityId() {
		return teacherEntityId;
	}
	public void setTeacherEntityId(Long teacherEntityId) {
		this.teacherEntityId = teacherEntityId;
	}

	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	@OneToMany
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
