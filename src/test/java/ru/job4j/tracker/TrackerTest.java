package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result).isEqualTo(item);
    }

    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result).isEqualTo(item);
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        List<Item> result = tracker.findAll();
        List<Item> expected = List.of(first, second);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        tracker.add(new Item("Third"));
        List<Item> result = tracker.findByName(second.getName());
        List<Item> expected = List.of(second);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenReplaceItemIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        int id = item.getId();
        Item expected = new Item("Bug with description");
        tracker.replace(id, expected);
        boolean result = tracker.replace(item.getId(), expected);
        assertThat(result).isTrue();
        assertThat(tracker.findById(id)).isEqualTo(expected);
    }

    @Test
    public void whenReplaceItemIsNotSuccessful() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        Item updateItem = new Item("Bug with description");
        boolean result = tracker.replace(1000, updateItem);
        assertThat(tracker.findAll()).containsExactly(item);
        assertThat(result).isFalse();
    }

    @Test
    public void whenDeleteItemIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        tracker.delete(item.getId());
        assertThat(tracker.findAll()).isEmpty();
    }

    @Test
    public void whenDeleteItemIsNotSuccessful() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        tracker.delete(1000);
        assertThat(tracker.findAll()).containsExactly(item);
    }
}