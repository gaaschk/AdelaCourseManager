package org.adela.is.awesome.coursemanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adela.is.awesome.coursemanager.persistence.entity.YearOfStudy;
import org.adela.is.awesome.coursemanager.persistence.repository.YearOfStudyRepository;
import org.adela.is.awesome.coursemanager.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/years")
public class YearOfStudyService {
	@Autowired
	private YearOfStudyRepository yearOfStudyRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Long saveCourse(@RequestBody YearOfStudy yos) {
		return yearOfStudyRepository.save(yos).getYearEntityId();

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<YearOfStudy> findAllCourses() {
		return CollectionUtils.toList(yearOfStudyRepository.findAll());
	}
	
	@Timed
	@RequestMapping(method=RequestMethod.PUT)
	public Long saveExisting(@RequestBody YearOfStudy entity){
		return yearOfStudyRepository.save(entity).getYearEntityId();
	}

	@Timed
	@RequestMapping(value="ping",method=RequestMethod.GET)
	public Map<String,Object> ping(){
		Map<String,Object> status = new HashMap<>();
		status.put("status", "ok");
		return status;
	}
	
	@Timed
	@RequestMapping(value = "{yearEntityId}", method = RequestMethod.GET)
	public YearOfStudy findOne(@PathVariable Long yearEntityId) {
		return yearOfStudyRepository.findOne(yearEntityId);
		
	}
	
	@Timed
	@RequestMapping(value = "{yearEntityId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long yearEntityId) {
		yearOfStudyRepository.delete(yearEntityId);
	}
}
