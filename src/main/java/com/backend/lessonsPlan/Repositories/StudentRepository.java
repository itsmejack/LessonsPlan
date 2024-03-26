package com.backend.lessonsPlan.Repositories;

import com.backend.lessonsPlan.Entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, String> {
}
