package org.adela.is.awesome.coursemanager.service;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.adela.is.awesome.coursemanager.Application;
import org.adela.is.awesome.coursemanager.TestUtil;
import org.adela.is.awesome.coursemanager.service.resource.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class StudentServiceTests {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testSaveAndRetrieve() throws Exception{
		Date testDate = new Date();
		Student student = new Student();
		mockMvc.perform(post("/student")
				.contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsBytes(student))
				)
		.andExpect(status().isOk())
		.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));
		
		mockMvc.perform(get("/student"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$", hasSize(1)));
	}
	
	@Test
	public void testPing() throws Exception {
		mockMvc.perform(get("/student/ping"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("status",is("ok")));
	}
}
