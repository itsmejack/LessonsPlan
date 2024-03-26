package com.backend.lessonsPlan.Repositories;

import com.backend.lessonsPlan.Entities.IntervalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervalRepository extends CrudRepository<IntervalEntity, Long> {
}
