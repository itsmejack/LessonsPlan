package com.backend.lessonsPlan.Entities;

import com.backend.lessonsPlan.Model.Day;
import com.backend.lessonsPlan.Model.NumberOfLesson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lessons")
public class LessonEntity {
    @Id
    private Long lessonId;
    private Day lessonDay;
    private NumberOfLesson numberOfLesson;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_teacher", referencedColumnName = "name")
    private TeacherEntity teacher;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_student", referencedColumnName = "name")
    private StudentEntity student;
}
