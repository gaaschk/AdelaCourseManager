package org.adela.is.awesome.coursemanager.client;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.MenuBar.MenuItem;

@SpringUI
public class HomePage extends UI {
	private static final long serialVersionUID = -7349115858008610032L;

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout content = new VerticalLayout();
		//content.setSizeFull();
		this.setContent(content);
		
		Label headerLabel = new Label("Adela is Awesome!");
		content.addComponent(headerLabel);
		
		MenuBar menuBar = new MenuBar();
		content.addComponent(menuBar);
		
		MenuItem studentMenuItem = menuBar.addItem("Students", null, null);
		MenuItem addStudent = studentMenuItem.addItem("add", null, null);
	}

}
