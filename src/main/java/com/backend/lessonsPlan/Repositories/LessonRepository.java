package com.backend.lessonsPlan.Repositories;

import com.backend.lessonsPlan.Entities.LessonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends CrudRepository<LessonEntity, Long> {
}
