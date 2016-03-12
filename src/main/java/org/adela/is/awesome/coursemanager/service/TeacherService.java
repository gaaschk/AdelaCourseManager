package org.adela.is.awesome.coursemanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.adela.is.awesome.coursemanager.service.resource.Teacher;
import java.util.ArrayList;
import org.adela.is.awesome.coursemanager.service.mapping.TeacherEntityToTeacherMapper;
import org.adela.is.awesome.coursemanager.persistence.entity.TeacherEntity;
import org.adela.is.awesome.coursemanager.persistence.repository.TeacherEntityRepository;
import org.adela.is.awesome.coursemanager.util.CollectionUtils;
import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/teacher")
public class TeacherService {
	
	@Autowired
	private TeacherEntityRepository teacherEntityRepository;
	
	@Timed
	@RequestMapping(method=RequestMethod.GET)
	public List<Teacher> findAll(){
		List<TeacherEntity> entities = CollectionUtils.toList(teacherEntityRepository.findAll());
		TeacherEntityToTeacherMapper mapper = TeacherEntityToTeacherMapper.INSTANCE; 
		List<Teacher> resources = new ArrayList<>();
		for(TeacherEntity entity:entities){
			resources.add(mapper.teacherEntityToTeacher(entity));
		}
		return resources;
	}
	
	@Timed
	@RequestMapping(method=RequestMethod.POST)
	public Long saveNew(@RequestBody Teacher resource){
		return this.save(resource, new TeacherEntity());
	}
	
	@Timed
	@RequestMapping(method=RequestMethod.PUT)
	public Long saveExisting(@RequestBody Teacher resource){
		TeacherEntity entity = teacherEntityRepository.findOne(resource.getTeacherId());
		return this.save(resource, entity);
	}

	private Long save(Teacher resource, TeacherEntity entity){
		TeacherEntityToTeacherMapper mapper = TeacherEntityToTeacherMapper.INSTANCE; 
		mapper.teacherToTeacherEntity(resource, entity);
		return teacherEntityRepository.save(entity).getTeacherEntityId();
	} 

	@Timed
	@RequestMapping(value="ping",method=RequestMethod.GET)
	public Map<String,Object> ping(){
		Map<String,Object> status = new HashMap<>();
		status.put("status", "ok");
		return status;
	}
}
