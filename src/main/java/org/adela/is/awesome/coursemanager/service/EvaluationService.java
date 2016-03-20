package org.adela.is.awesome.coursemanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adela.is.awesome.coursemanager.persistence.entity.Evaluation;
import org.adela.is.awesome.coursemanager.persistence.repository.EvaluationRepository;
import org.adela.is.awesome.coursemanager.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/evaluation")
public class EvaluationService {
	@Autowired
	private EvaluationRepository evaluationRepository;
	
	@Timed
	@RequestMapping(method=RequestMethod.GET)
	public List<Evaluation> findAll(){
		List<Evaluation> entities = CollectionUtils.toList(evaluationRepository.findAll());
		return entities;
	}
	
	@Timed
	@RequestMapping(method=RequestMethod.POST)
	public Long saveNew(@RequestBody Evaluation entity){
		return evaluationRepository.save(entity).getEvaluationEntityId();
	}
	
	@Timed
	@RequestMapping(method=RequestMethod.PUT)
	public Long saveExisting(@RequestBody Evaluation entity){
		return evaluationRepository.save(entity).getEvaluationEntityId();
	}

	@Timed
	@RequestMapping(value="ping",method=RequestMethod.GET)
	public Map<String,Object> ping(){
		Map<String,Object> status = new HashMap<>();
		status.put("status", "ok");
		return status;
	}
	@Timed
	@RequestMapping(value = "{evaluationEntityId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long evaluationEntityId) {
		evaluationRepository.delete(evaluationEntityId);
	}
}
