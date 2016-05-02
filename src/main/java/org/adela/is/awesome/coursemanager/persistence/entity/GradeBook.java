package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GradeBook {
private Long idGradeBook;
private StudentDetails studentDetails;
private Semester semester;
private Course course;
//average??

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Long getIdGradeBook() {
	return idGradeBook;
}
public void setIdGradeBook(Long idGradeBook) {
	this.idGradeBook = idGradeBook;
}

@ManyToOne
public StudentDetails getStudentDetails() {
	return studentDetails;
}
public void setStudentDetails(StudentDetails studentDetails) {
	this.studentDetails = studentDetails;
}

@ManyToOne
public Semester getSemester() {
	return semester;
}
public void setSemester(Semester semester) {
	this.semester = semester;
}
@ManyToOne
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}


	
}
