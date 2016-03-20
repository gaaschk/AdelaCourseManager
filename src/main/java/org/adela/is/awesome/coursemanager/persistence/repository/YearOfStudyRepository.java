package org.adela.is.awesome.coursemanager.persistence.repository;

import org.adela.is.awesome.coursemanager.persistence.entity.YearOfStudy;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface YearOfStudyRepository extends
		PagingAndSortingRepository<YearOfStudy, Long> {

}
