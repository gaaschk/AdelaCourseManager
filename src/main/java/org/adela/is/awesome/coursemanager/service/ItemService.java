package org.adela.is.awesome.coursemanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adela.is.awesome.coursemanager.persistence.entity.Item;
import org.adela.is.awesome.coursemanager.persistence.repository.ItemRepository;
import org.adela.is.awesome.coursemanager.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/items")
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	
	@Timed
	@RequestMapping(method=RequestMethod.GET)
	public List<Item> findAll(){
		List<Item> entities = CollectionUtils.toList(itemRepository.findAll());
		return entities;
	}
	
	@Timed
	@RequestMapping(method=RequestMethod.POST)
	public Long saveNew(@RequestBody Item entity){
		return itemRepository.save(entity).getTypeEntityId();
	}
	
	@Timed
	@RequestMapping(method=RequestMethod.PUT)
	public Long saveExisting(@RequestBody Item entity){
		return itemRepository.save(entity).getTypeEntityId();
	}

	@Timed
	@RequestMapping(value="ping",method=RequestMethod.GET)
	public Map<String,Object> ping(){
		Map<String,Object> status = new HashMap<>();
		status.put("status", "ok");
		return status;
	}
	@Timed
	@RequestMapping(value = "{typeEntityId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long typeEntityId) {
		itemRepository.delete(typeEntityId);
	}
	
	
}
