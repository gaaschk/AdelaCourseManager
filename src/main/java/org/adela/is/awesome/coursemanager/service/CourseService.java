package org.adela.is.awesome.coursemanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adela.is.awesome.coursemanager.persistence.entity.Course;
import org.adela.is.awesome.coursemanager.persistence.repository.CourseRepository;
import org.adela.is.awesome.coursemanager.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/courses")
public class CourseService {
	@Autowired
	private CourseRepository courseEntityRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Long saveCourse(@RequestBody Course c) {
		return courseEntityRepository.save(c).getCourseEntityId();

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Course> findAllCourses() {
		return CollectionUtils.toList(courseEntityRepository.findAll());
	}
	
	@Timed
	@RequestMapping(method=RequestMethod.PUT)
	public Long saveExisting(@RequestBody Course entity){
		return courseEntityRepository.save(entity).getCourseEntityId();
	}

	@Timed
	@RequestMapping(value="ping",method=RequestMethod.GET)
	public Map<String,Object> ping(){
		Map<String,Object> status = new HashMap<>();
		status.put("status", "ok");
		return status;
	}
	
	@Timed
	@RequestMapping(value = "{courseEntityId}", method = RequestMethod.GET)
	public Course findOne(@PathVariable Long courseEntityId) {
		return courseEntityRepository.findOne(courseEntityId);
		
	}
	
	@Timed
	@RequestMapping(value = "{courseEntityId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long courseEntityId) {
		courseEntityRepository.delete(courseEntityId);
	}
	
}
