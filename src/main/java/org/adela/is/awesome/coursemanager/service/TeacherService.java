package org.adela.is.awesome.coursemanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adela.is.awesome.coursemanager.persistence.entity.TeacherEntity;
import org.adela.is.awesome.coursemanager.persistence.repository.TeacherEntityRepository;
import org.adela.is.awesome.coursemanager.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/teacher")
public class TeacherService {
	
	@Autowired
	private TeacherEntityRepository teacherEntityRepository;
	
	@Timed
	@RequestMapping(method=RequestMethod.GET)
	public List<TeacherEntity> findAll(){
		List<TeacherEntity> entities = CollectionUtils.toList(teacherEntityRepository.findAll());
		return entities;
	}
	
	@Timed
	@RequestMapping(method=RequestMethod.POST)
	public Long saveNew(@RequestBody TeacherEntity entity){
		return teacherEntityRepository.save(entity).getTeacherEntityId();
	}
	
	@Timed
	@RequestMapping(method=RequestMethod.PUT)
	public Long saveExisting(@RequestBody TeacherEntity entity){
		return teacherEntityRepository.save(entity).getTeacherEntityId();
	}

	@Timed
	@RequestMapping(value="{teacherId}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long teacherId){
		teacherEntityRepository.delete(teacherId);
	}

	@Timed
	@RequestMapping(value="ping",method=RequestMethod.GET)
	public Map<String,Object> ping(){
		Map<String,Object> status = new HashMap<>();
		status.put("status", "ok");
		return status;
	}
}
