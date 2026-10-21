package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemDescByNameTest {
    @Test
    public void whenItemsDescByName() {
        Item first = new Item(1, "Задача 1");
        Item second = new Item(2, "Задача 2");
        Item third = new Item(3, "Задача 3");

        List<Item> items = new ArrayList<>(List.of(
                third, first, second
        ));

        List<Item> expected = new ArrayList<>(List.of(
                third, second, first
        ));
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}