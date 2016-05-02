package org.adela.is.awesome.coursemanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	private Long typeEntityId;
	private String typeName;
	private ItemGroup itemGroup;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getTypeEntityId() {
		return typeEntityId;
	}
	public void setTypeEntityId(Long typeEntityId) {
		this.typeEntityId = typeEntityId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@ManyToOne
	public ItemGroup getItemGroup() {
		return itemGroup;
	}
	public void setItemGroup(ItemGroup itemGroup) {
		this.itemGroup = itemGroup;
	}
	
	
}
