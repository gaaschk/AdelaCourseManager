package org.adela.is.awesome.coursemanager.persistence.repository;

import org.adela.is.awesome.coursemanager.persistence.entity.ClassEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClassRepository extends PagingAndSortingRepository<ClassEntity, Long> {

}
