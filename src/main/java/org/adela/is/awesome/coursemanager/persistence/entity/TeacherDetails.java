package org.adela.is.awesome.coursemanager.persistence.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TeacherDetails {
	
private Long idTeacherDetails;
private TeacherEntity teacher;
private Course course;
private ClassEntity classEntity;
private YearOfStudy studyYear;
private SchoolYear schoolYear;
private Integer numerOfHoursWeek;



@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Long getIdTeacherDetails() {
	return idTeacherDetails;
}
public void setIdTeacherDetails(Long idTeacherDetails) {
	this.idTeacherDetails = idTeacherDetails;
}
@ManyToOne
public TeacherEntity getTeacher() {
	return teacher;
}
public void setTeacher(TeacherEntity teacher) {
	this.teacher = teacher;
}
@ManyToOne
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
@ManyToOne
public ClassEntity getClassEntity() {
	return classEntity;
}
public void setClassEntity(ClassEntity classEntity) {
	this.classEntity = classEntity;
}
@ManyToOne
public YearOfStudy getStudyYear() {
	return studyYear;
}
public void setStudyYear(YearOfStudy studyYear) {
	this.studyYear = studyYear;
}
@ManyToOne
public SchoolYear getSchoolYear() {
	return schoolYear;
}
public void setSchoolYear(SchoolYear schoolYear) {
	this.schoolYear = schoolYear;
}
public Integer getNumerOfHoursWeek() {
	return numerOfHoursWeek;
}
public void setNumerOfHoursWeek(Integer numerOfHoursWeek) {
	this.numerOfHoursWeek = numerOfHoursWeek;
}

	
}
