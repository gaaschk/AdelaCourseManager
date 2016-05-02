package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ItemGroup {
private Long idItemGroup;
private String nameItemGroup;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Long getIdItemGroup() {
	return idItemGroup;
}
public void setIdItemGroup(Long idItemGroup) {
	this.idItemGroup = idItemGroup;
}
public String getNameItemGroup() {
	return nameItemGroup;
}
public void setNameItemGroup(String nameItemGroup) {
	this.nameItemGroup = nameItemGroup;
}


	
}
