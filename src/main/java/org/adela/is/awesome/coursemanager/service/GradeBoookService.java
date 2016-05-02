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

import com.codahale.metrics.annotation.Timed;

public class GradeBoookService {
	@Autowired
	private GradeBookRepository gradeBookRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Long saveGrade(@RequestBody GradeBook gb) {
		return gradeBookRepository.save(gb).getIdGradeBook();

	}

	//per student, not all
	@RequestMapping(method = RequestMethod.GET)
	public List<GradeBook> findAllgrades() {
		return CollectionUtils.toList(gradeBookRepository.findAll());
	}

	@Timed
	@RequestMapping(method = RequestMethod.PUT)
	public Long saveExisting(@RequestBody GradeBook entity) {
		return gradeBookRepository.save(entity).getIdGradeBook();
	}

	@Timed
	@RequestMapping(value = "ping", method = RequestMethod.GET)
	public Map<String, Object> ping() {
		Map<String, Object> status = new HashMap<>();
		status.put("status", "ok");
		return status;
	}
	
//get one for a student
	@Timed
	@RequestMapping(value = "{idGradeBook}", method = RequestMethod.GET)
	public GradeBook findOne(@PathVariable Long idGradeBook) {
		return gradeBookRepository.findOne(idGradeBook);

	}

	//delete one for a student
	@Timed
	@RequestMapping(value = "{idGradeBook}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long idGradeBook) {
		gradeBookRepository.delete(idGradeBook);
	}
	
	
}
