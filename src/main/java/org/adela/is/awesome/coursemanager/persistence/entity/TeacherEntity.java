package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;




@Entity
public class TeacherEntity {
	private Long teacherEntityId;
	private String teacherName; 
	
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
}
