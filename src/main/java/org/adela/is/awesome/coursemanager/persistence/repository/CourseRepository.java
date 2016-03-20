package org.adela.is.awesome.coursemanager.persistence.repository;

import org.adela.is.awesome.coursemanager.persistence.entity.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

}
