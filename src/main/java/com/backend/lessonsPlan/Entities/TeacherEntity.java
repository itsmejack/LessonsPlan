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
@Table(name = "teachers")
public class TeacherEntity {
    @Id
    private String name;
    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private Set<LessonEntity> lessons;
    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private Set<IntervalEntity> freeIntervals;
}
