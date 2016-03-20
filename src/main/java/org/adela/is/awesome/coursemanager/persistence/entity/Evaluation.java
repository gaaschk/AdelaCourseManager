package org.adela.is.awesome.coursemanager.persistence.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Evaluation {
	
	private Long evaluationEntityId;
	private Double grade;
	private Date date;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getEvaluationEntityId() {
		return evaluationEntityId;
	}
	public void setEvaluationEntityId(Long evaluationEntityId) {
		this.evaluationEntityId = evaluationEntityId;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
