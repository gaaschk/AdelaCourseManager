package org.adela.is.awesome.coursemanager.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import org.adela.is.awesome.coursemanager.persistence.entity.TeacherEntity;

public interface TeacherEntityRepository extends PagingAndSortingRepository<TeacherEntity, Long>{

}
