package org.adela.is.awesome.coursemanager.client;


import org.adela.is.awesome.coursemanager.persistence.entity.TeacherEntity;
import org.adela.is.awesome.coursemanager.persistence.repository.TeacherEntityRepository;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class TeacherView extends HorizontalLayout{
	private static final long serialVersionUID = -2113437146028895009L;
	
	private TeacherEntityRepository teacherRepo;

	private Table teacherDataTable;
	private TextField nameField = new TextField();
	private TeacherEntity selectedTeacher;

	public TeacherView(TeacherEntityRepository teacherRepo){
		this.teacherRepo = teacherRepo;
		
		VerticalLayout tablePanel = new VerticalLayout();
		teacherDataTable = new Table();
		teacherDataTable.addContainerProperty("Name", String.class, null);
		teacherDataTable.setSelectable(true);
		teacherDataTable.setImmediate(true);
		teacherDataTable.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = 9162327903714422573L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				updateSelectedTeacher();
			}
		});
		this.reloadTableData();
		this.addComponent(teacherDataTable);
		HorizontalLayout tableButtonPanel = new HorizontalLayout();
		tableButtonPanel.addComponent(new Button("Add", new ClickListener(){
			private static final long serialVersionUID = -6993444717330844610L;

			@Override
			public void buttonClick(ClickEvent event) {
				TeacherEntity newTeacher = new TeacherEntity();
				newTeacher.setTeacherName("");
				newTeacher = teacherRepo.save(newTeacher);
				reloadTableData();
			}}));
		tableButtonPanel.addComponent(new Button("Delete", new ClickListener(){
			private static final long serialVersionUID = -6993444717330844610L;

			@Override
			public void buttonClick(ClickEvent event) {
				Long selectedTeacherId = (Long)teacherDataTable.getValue();
				teacherRepo.delete(selectedTeacherId);
				reloadTableData();
			}}));
		tablePanel.addComponent(tableButtonPanel);
		this.addComponent(tablePanel);
		VerticalLayout formPanel = new VerticalLayout();
		
		GridLayout formDataPanel = new GridLayout(2,1);
		formDataPanel.addComponent(new Label("Teacher Name:"),0,0);
		formDataPanel.addComponent(nameField,1,0);
		this.addComponent(formDataPanel);
		Button saveButton = new Button("Save", new ClickListener() {
			private static final long serialVersionUID = -3076728302768059993L;

			@Override
			public void buttonClick(ClickEvent event) {
				if(selectedTeacher!=null){
					selectedTeacher.setTeacherName(nameField.getValue());
					teacherRepo.save(selectedTeacher);
					reloadTableData();
				}
			}
		});
		formPanel.addComponent(saveButton);
		this.addComponent(formPanel);
	}
	
	public void reloadTableData(){
		teacherDataTable.removeAllItems();
		Iterable<TeacherEntity> allTeachers = teacherRepo.findAll();
		allTeachers.forEach(t -> teacherDataTable.addItem(new Object[]{t.getTeacherName()}, t.getTeacherEntityId()));
		teacherDataTable.setPageLength(teacherDataTable.size());
		
	}
	private void updateSelectedTeacher(){
		Long selectedTeacherId =  (Long)teacherDataTable.getValue();
		if(selectedTeacherId!=null){
			selectedTeacher = teacherRepo.findOne(selectedTeacherId);
			nameField.setValue(selectedTeacher.getTeacherName());
		}
	}
}
