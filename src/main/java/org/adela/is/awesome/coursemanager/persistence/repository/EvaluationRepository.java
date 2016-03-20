package org.adela.is.awesome.coursemanager.persistence.repository;

import org.adela.is.awesome.coursemanager.persistence.entity.Evaluation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EvaluationRepository extends PagingAndSortingRepository<Evaluation, Long> {

}
