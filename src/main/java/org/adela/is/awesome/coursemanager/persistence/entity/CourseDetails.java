package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CourseDetails {
private Long idCourseDetails;
private ClassDetails classDetails;
private TeacherEntity teacherEntity;
private Course course;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Long getIdCourseDetails() {
	return idCourseDetails;
}
public void setIdCourseDetails(Long idCourseDetails) {
	this.idCourseDetails = idCourseDetails;
}
@ManyToOne
public ClassDetails getClassDetails() {
	return classDetails;
}
public void setClassDetails(ClassDetails classDetails) {
	this.classDetails = classDetails;
}
@ManyToOne
public TeacherEntity getTeacherEntity() {
	return teacherEntity;
}
public void setTeacherEntity(TeacherEntity teacherEntity) {
	this.teacherEntity = teacherEntity;
}
@ManyToOne
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}



	
	
}
