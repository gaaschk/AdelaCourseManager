package org.adela.is.awesome.coursemanager.client;

import org.adela.is.awesome.coursemanager.persistence.entity.StudentEntity;
import org.adela.is.awesome.coursemanager.persistence.repository.StudentEntityRepository;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class StudentView extends HorizontalSplitPanel{
	private static final long serialVersionUID = -2113437146028895009L;
	
	private StudentEntityRepository studentRepo;

	private Table studentDataTable;
	private TextField nameField = new TextField();
	
	public StudentView(StudentEntityRepository studentRepo){
		this.studentRepo = studentRepo;
		
		VerticalLayout tablePanel = new VerticalLayout();
		studentDataTable = new Table();
		studentDataTable.setSelectable(true);
		studentDataTable.setImmediate(true);
		studentDataTable.addContainerProperty("Name", String.class, null);
		this.reloadTableData();
		tablePanel.addComponent(studentDataTable);
		HorizontalLayout tableButtonPanel = new HorizontalLayout();
		tableButtonPanel.addComponent(new Button("Add", new ClickListener(){
			private static final long serialVersionUID = -6993444717330844610L;

			@Override
			public void buttonClick(ClickEvent event) {
				StudentEntity newStudent = new StudentEntity();
				newStudent.setStudentName("");
				newStudent = studentRepo.save(newStudent);
				reloadTableData();
			}}));
		tableButtonPanel.addComponent(new Button("Delete", new ClickListener(){
			private static final long serialVersionUID = -6993444717330844610L;

			@Override
			public void buttonClick(ClickEvent event) {
				Long selectedStudentId = (Long)studentDataTable.getValue();
				studentRepo.delete(selectedStudentId);
				reloadTableData();
			}}));
		tablePanel.addComponent(tableButtonPanel);
		this.addComponent(tablePanel);
		GridLayout formPanel = new GridLayout(2,1);
		formPanel.addComponent(new Label("Strudent Name:"),0,0);
		formPanel.addComponent(nameField,1,0);
		this.addComponent(formPanel);
	}
	
	public void reloadTableData(){
		studentDataTable.removeAllItems();
		Iterable<StudentEntity> allStudents = studentRepo.findAll();
		allStudents.forEach(s -> studentDataTable.addItem(new Object[]{s.getStudentName()}, s.getStudentEntityId()));
		studentDataTable.setPageLength(studentDataTable.size());
		studentDataTable.setValue(studentDataTable.getCurrentPageFirstItemId());
	}
}
