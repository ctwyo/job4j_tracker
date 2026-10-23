package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobAscByPriorityTest {
    @Test
    public void whenAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Dix bug", 4),
                new Job("Aix bug", 2),
                new Job("Bix bug", 0)
        );
        jobs.sort(new JobAscByPriority());
        assertThat(jobs)
                .extracting(Job::getPriority)
                .containsExactly(
                        0,
                        1,
                        2,
                        4
                );
    }

}