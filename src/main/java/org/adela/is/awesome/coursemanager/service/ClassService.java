package org.adela.is.awesome.coursemanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adela.is.awesome.coursemanager.persistence.entity.ClassEntity;
import org.adela.is.awesome.coursemanager.persistence.repository.ClassRepository;
import org.adela.is.awesome.coursemanager.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codahale.metrics.annotation.Timed;

public class ClassService {
	@Autowired
	private ClassRepository classRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Long saveCourse(@RequestBody ClassEntity ce) {
		return classRepository.save(ce).getClassEntityId();

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<ClassEntity> findAllCourses() {
		return CollectionUtils.toList(classRepository.findAll());
	}

	@Timed
	@RequestMapping(method = RequestMethod.PUT)
	public Long saveExisting(@RequestBody ClassEntity entity) {
		return classRepository.save(entity).getClassEntityId();
	}

	@Timed
	@RequestMapping(value = "ping", method = RequestMethod.GET)
	public Map<String, Object> ping() {
		Map<String, Object> status = new HashMap<>();
		status.put("status", "ok");
		return status;
	}

	@Timed
	@RequestMapping(value = "{classEntityId}", method = RequestMethod.GET)
	public ClassEntity findOne(@PathVariable Long classEntityId) {
		return classRepository.findOne(classEntityId);

	}

	@Timed
	@RequestMapping(value = "{classEntityId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long classEntityId) {
		classRepository.delete(classEntityId);
	}

}
