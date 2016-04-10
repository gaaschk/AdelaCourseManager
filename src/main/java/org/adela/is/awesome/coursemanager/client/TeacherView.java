package org.adela.is.awesome.coursemanager.client;

import org.adela.is.awesome.coursemanager.persistence.entity.TeacherEntity;
import org.adela.is.awesome.coursemanager.persistence.repository.TeacherEntityRepository;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;

public class TeacherView extends HorizontalLayout{
	private static final long serialVersionUID = -2113437146028895009L;
	
	private TeacherEntityRepository teacherRepo;

	private Table teacherDataTable;
	private TextField nameField = new TextField();
	
	public TeacherView(TeacherEntityRepository teacherRepo){
		this.teacherRepo = teacherRepo;
		
		teacherDataTable = new Table();
		teacherDataTable.addContainerProperty("Name", String.class, null);
		this.reloadTableData();
		this.addComponent(teacherDataTable);
		GridLayout formPanel = new GridLayout(2,1);
		formPanel.addComponent(new Label("Teacher Name:"),0,0);
		formPanel.addComponent(nameField,1,0);
		this.addComponent(formPanel);
	}
	
	public void reloadTableData(){
		teacherDataTable.removeAllItems();
		Iterable<TeacherEntity> allStudents = teacherRepo.findAll();
		allStudents.forEach(t -> teacherDataTable.addItem(new Object[]{t.getTeacherName()}, t.getTeacherEntityId()));
		teacherDataTable.setPageLength(teacherDataTable.size());
		
	}
}
