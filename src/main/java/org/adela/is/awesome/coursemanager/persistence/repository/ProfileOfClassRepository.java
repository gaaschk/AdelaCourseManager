package org.adela.is.awesome.coursemanager.persistence.repository;

import org.adela.is.awesome.coursemanager.persistence.entity.ProfileOfClass;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfileOfClassRepository extends
		PagingAndSortingRepository<ProfileOfClass, Long> {

}
