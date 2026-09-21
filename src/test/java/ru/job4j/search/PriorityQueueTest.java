package ru.job4j.search;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPrioritySecond() {
        PriorityQueue queue = new PriorityQueue();
        Task expected = new Task("urgent", 1);
        queue.put(new Task("low", 5));
        queue.put(expected);
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenHigherPriorityEquals() {
        PriorityQueue queue = new PriorityQueue();
        Task expected = new Task("low", 1);
        queue.put(expected);
        queue.put(new Task("urgent", 5));
        queue.put(new Task("middle", 5));
        Task result = queue.take();
        assertThat(result).isEqualTo(expected);
    }
}