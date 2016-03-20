package org.adela.is.awesome.coursemanager.persistence.repository;

import org.adela.is.awesome.coursemanager.persistence.entity.Item;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

}
