package com.backend.lessonsPlan.Repositories;

import com.backend.lessonsPlan.Entities.TeacherEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<TeacherEntity, String> {
}
