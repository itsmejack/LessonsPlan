package com.backend.lessonsPlan.Entities;

import com.backend.lessonsPlan.Model.Day;
import com.backend.lessonsPlan.Model.NumberOfLesson;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "intervals")
public class IntervalEntity {
    @Id
    private Long id;
    private Day intervalDay;
    private NumberOfLesson numberOfLesson;
}
