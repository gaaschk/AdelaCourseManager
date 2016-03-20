package org.adela.is.awesome.coursemanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adela.is.awesome.coursemanager.persistence.entity.GradeBook;
import org.adela.is.awesome.coursemanager.persistence.repository.GradeBookRepository;
import org.adela.is.awesome.coursemanager.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/gradebook")
public class GradeBookService {
	@Autowired
	private GradeBookRepository gradeBookRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Long saveCourse(@RequestBody GradeBook gb) {
		return gradeBookRepository.save(gb).getGradeBookEntityId();

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<GradeBook> findAllCourses() {
		return CollectionUtils.toList(gradeBookRepository.findAll());
	}

	@Timed
	@RequestMapping(method = RequestMethod.PUT)
	public Long saveExisting(@RequestBody GradeBook entity) {
		return gradeBookRepository.save(entity).getGradeBookEntityId();
	}

	@Timed
	@RequestMapping(value = "ping", method = RequestMethod.GET)
	public Map<String, Object> ping() {
		Map<String, Object> status = new HashMap<>();
		status.put("status", "ok");
		return status;
	}

	@Timed
	@RequestMapping(value = "{gradeBookEntityId}", method = RequestMethod.GET)
	public GradeBook findOne(@PathVariable Long gradeBookEntityId) {
		return gradeBookRepository.findOne(gradeBookEntityId);

	}

	@Timed
	@RequestMapping(value = "{gradeBookEntityId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long gradeBookEntityId) {
		gradeBookRepository.delete(gradeBookEntityId);
	}
}
