package org.adela.is.awesome.coursemanager.client;

import org.adela.is.awesome.coursemanager.persistence.repository.StudentEntityRepository;
import org.adela.is.awesome.coursemanager.persistence.repository.TeacherEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
public class HomePage extends UI {
	private static final long serialVersionUID = -7349115858008610032L;
	
	@Autowired
	private StudentEntityRepository studentRepository;
	@Autowired
	private TeacherEntityRepository teacherRepository;

	private VerticalLayout content;
	private StudentView studentView;
	private TeacherView teacherView;
	
	@Override
	protected void init(VaadinRequest request) {
		content = new VerticalLayout();
		//content.setSizeFull();
		this.setContent(content);
		
		Label headerLabel = new Label("Adela is Awesome!");
		content.addComponent(headerLabel);
		
		HorizontalLayout menuBar = new HorizontalLayout();
		content.addComponent(menuBar);
		menuBar.addComponent(new Button("Students", new ClickListener(){
			private static final long serialVersionUID = 9021075807839550119L;

			@Override
			public void buttonClick(ClickEvent event) {
				loadStudentView();
			}}));
		menuBar.addComponent(new Button("Teachers", new ClickListener(){
			private static final long serialVersionUID = 9021075807839550119L;

			@Override
			public void buttonClick(ClickEvent event) {
				loadTeacherView();
			}}));
		
		studentView = new StudentView(studentRepository);
		content.addComponent(studentView);
		teacherView = new TeacherView(teacherRepository);
	}
	
	protected void loadStudentView(){
		content.replaceComponent(content.getComponent(2), studentView);
	}
	protected void loadTeacherView(){
		content.replaceComponent(content.getComponent(2), teacherView);
	}
	
}
