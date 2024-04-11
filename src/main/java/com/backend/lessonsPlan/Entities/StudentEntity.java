package com.backend.lessonsPlan.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class StudentEntity {
    @Id
    private String name;
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private Set<LessonEntity> lessons;
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private Set<IntervalEntity> freeIntervals;
}
