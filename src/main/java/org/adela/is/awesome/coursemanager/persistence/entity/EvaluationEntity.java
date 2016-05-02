package org.adela.is.awesome.coursemanager.persistence.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EvaluationEntity {
private Long idEvaluation;
private GradeBook gradebook;
private Date evaluationDate;
private Double grade;


@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Long getIdEvaluation() {
	return idEvaluation;
}
public void setIdEvaluation(Long idEvaluation) {
	this.idEvaluation = idEvaluation;
}
@ManyToOne
public GradeBook getGradebook() {
	return gradebook;
}
public void setGradebook(GradeBook gradebook) {
	this.gradebook = gradebook;
}
public Date getEvaluationDate() {
	return evaluationDate;
}
public void setEvaluationDate(Date evaluationDate) {
	this.evaluationDate = evaluationDate;
}
public Double getGrade() {
	return grade;
}
public void setGrade(Double grade) {
	this.grade = grade;
}

	
	
}
