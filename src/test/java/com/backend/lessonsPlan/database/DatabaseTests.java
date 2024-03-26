package com.backend.lessonsPlan.database;

import com.backend.lessonsPlan.Entities.IntervalEntity;
import com.backend.lessonsPlan.Repositories.IntervalRepository;
import com.backend.lessonsPlan.TestDataFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DatabaseTests {

    private IntervalRepository intervalRepository;

    @Autowired
    public DatabaseTests(IntervalRepository intervalRepository) {
        this.intervalRepository = intervalRepository;
    }
    @Test
    public void assertInterval() {
        IntervalEntity intervalEntity = TestDataFactory.createInterval();
        intervalRepository.save(intervalEntity);
        Optional<IntervalEntity> result = intervalRepository.findById(intervalEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(intervalEntity);
    }
}
