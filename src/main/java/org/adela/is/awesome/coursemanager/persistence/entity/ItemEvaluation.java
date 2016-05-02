package org.adela.is.awesome.coursemanager.persistence.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ItemEvaluation {
private Long idItemEvaluation;
private GradeBook gradebook;
private Item item;
private Date dateItemEvaluation;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Long getIdItemEvaluation() {
	return idItemEvaluation;
}
public void setIdItemEvaluation(Long idItemEvaluation) {
	this.idItemEvaluation = idItemEvaluation;
}
@ManyToOne
public GradeBook getGradebook() {
	return gradebook;
}
public void setGradebook(GradeBook gradebook) {
	this.gradebook = gradebook;
}
@ManyToOne
public Item getItem() {
	return item;
}
public void setItem(Item item) {
	this.item = item;
}
public Date getDateItemEvaluation() {
	return dateItemEvaluation;
}
public void setDateItemEvaluation(Date dateItemEvaluation) {
	this.dateItemEvaluation = dateItemEvaluation;
}


}
