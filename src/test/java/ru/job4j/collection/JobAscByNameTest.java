package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobAscByNameTest {
    @Test
    public void whenAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Dix bug", 4),
                new Job("Aix bug", 2),
                new Job("Bix bug", 0)
        );
        jobs.sort(new JobAscByName());
       assertThat(jobs)
               .extracting(Job::getName)
               .containsExactly(
                       "Aix bug",
                       "Bix bug",
                       "Dix bug",
                       "Fix bug"
               );
    }
}