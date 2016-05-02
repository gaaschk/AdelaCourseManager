package org.adela.is.awesome.coursemanager.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import org.adela.is.awesome.coursemanager.persistence.entity.StudentEntity;

public interface StudentEntityRepository extends PagingAndSortingRepository<StudentEntity, Long>{

}
