package org.adela.is.awesome.coursemanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adela.is.awesome.coursemanager.persistence.entity.StudentEntity;
import org.adela.is.awesome.coursemanager.persistence.repository.StudentEntityRepository;
import org.adela.is.awesome.coursemanager.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/student")
public class StudentService {
	
	@Autowired
	private StudentEntityRepository studentEntityRepository;
	
	@Timed
	@RequestMapping(method=RequestMethod.GET)
	public List<StudentEntity> findAll(){
		List<StudentEntity> entities = CollectionUtils.toList(studentEntityRepository.findAll());
		return entities;
	}
	
	@Timed
	@RequestMapping(method=RequestMethod.POST)
	public Long saveNew(@RequestBody StudentEntity entity){
		return studentEntityRepository.save(entity).getStudentEntityId();
	}
	
	@Timed
	@RequestMapping(method=RequestMethod.PUT)
	public Long saveExisting(@RequestBody StudentEntity entity){
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
