package org.adela.is.awesome.coursemanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.adela.is.awesome.coursemanager.service.resource.Student;
import java.util.ArrayList;
import org.adela.is.awesome.coursemanager.service.mapping.StudentEntityToStudentMapper;
import org.adela.is.awesome.coursemanager.persistence.entity.StudentEntity;
import org.adela.is.awesome.coursemanager.persistence.repository.StudentEntityRepository;
import org.adela.is.awesome.coursemanager.util.CollectionUtils;
import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/student")
public class StudentService {
	
	@Autowired
	private StudentEntityRepository studentEntityRepository;
	
	@Timed
	@RequestMapping(method=RequestMethod.GET)
	public List<Student> findAll(){
		List<StudentEntity> entities = CollectionUtils.toList(studentEntityRepository.findAll());
		StudentEntityToStudentMapper mapper = StudentEntityToStudentMapper.INSTANCE; 
		List<Student> resources = new ArrayList<>();
		for(StudentEntity entity:entities){
			resources.add(mapper.studentEntityToStudent(entity));
		}
		return resources;
	}
	
	@Timed
	@RequestMapping(method=RequestMethod.POST)
	public Long saveNew(@RequestBody Student resource){
		return this.save(resource, new StudentEntity());
	}
	
	@Timed
	@RequestMapping(method=RequestMethod.PUT)
	public Long saveExisting(@RequestBody Student resource){
		StudentEntity entity = studentEntityRepository.findOne(resource.getStudentId());
		return this.save(resource, entity);
	}

	private Long save(Student resource, StudentEntity entity){
		StudentEntityToStudentMapper mapper = StudentEntityToStudentMapper.INSTANCE; 
		mapper.studentToStudentEntity(resource, entity);
		return studentEntityRepository.save(entity).getStudentEntityId();
	} 

	@Timed
	@RequestMapping(value="ping",method=RequestMethod.GET)
	public Map<String,Object> ping(){
		Map<String,Object> status = new HashMap<>();
		status.put("status", "ok");
		return status;
	}
}
